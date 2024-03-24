package lxpnh98.poppop;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Circle;
import org.dyn4j.geometry.Segment;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.world.World;

/**
 * JavaFX App
 */
public class App extends Application {
    static private long lastNow;
    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var player = new Player(10, 40, "images/player.png");
        var canvas = new Canvas(300, 300);

        var root = new Group();
        var scene = new Scene(root, 500, 400);
        root.getChildren().add(canvas);
        stage.setScene(scene);
        stage.show();

        var world = new World<Body>();
        world.setGravity(0, 9.8);

        var bubble = new Body();
        var fixture = bubble.addFixture(new Circle(50));
        fixture.setDensity(10);
        fixture.setRestitution(1.0);
        bubble.translateToOrigin();
        bubble.translate(250, 100);
        bubble.setMass(MassType.valueOf("NORMAL"));
        world.addBody(bubble);

        var bubble2 = new Body();
        var fixture2 = bubble2.addFixture(new Circle(30));
        fixture2.setDensity(10);
        fixture2.setRestitution(1.0);
        bubble2.translateToOrigin();
        bubble2.translate(150, 230);
        bubble2.setMass(MassType.valueOf("NORMAL"));
        world.addBody(bubble2);

        var floor = new Body();
        floor.addFixture(new Segment(new Vector2(0, 300), new Vector2(300, 300)));
        world.addBody(floor);

        var renderer = new Renderer(canvas);
        renderer.addPlayer(player);
        renderer.addBubble(bubble);
        renderer.addBubble(bubble2);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case LEFT:  player.goLeft(); break;
                    case RIGHT: player.goRight(); break;
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case LEFT:  player.stopLeft(); break;
                    case RIGHT: player.stopRight(); break;
                }
            }
        });

        startGame(renderer, world, player);
    }

    private void startGame(Renderer renderer, World world, Player player) {
        var gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                var elapsedTime = (now - App.lastNow) / 1e9;
                App.lastNow = now;
                player.move();
                world.update(elapsedTime);
                renderer.render();
            };
        };
        gameLoop.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

