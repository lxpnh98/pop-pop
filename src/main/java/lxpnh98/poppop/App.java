package lxpnh98.poppop;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
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

        var renderer = new Renderer(canvas);
        renderer.addPlayer(player);

        startGame(renderer, player);
    }

    private void startGame(Renderer renderer, Player player) {
        var gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                renderer.render();
                player.move(1, 0);
            };
        };
        gameLoop.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

