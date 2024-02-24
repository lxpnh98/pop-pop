package lxpnh98.poppop;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import lxpnh98.poppop.Player;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var classLoader = getClass().getClassLoader();
        var imageUrl = classLoader.getResource("images/player.png").toExternalForm();
        var image = new Image(imageUrl);

        var canvas = new Canvas(300, 300);
        var gc = canvas.getGraphicsContext2D();

        // background
        gc.setFill(Color.BLUE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        // player
        gc.drawImage(image, 10, 40);
        // bubble
        gc.strokeOval(200, 100, 100, 100);

        var root = new Group();
        var scene = new Scene(root, 500, 400);
        root.getChildren().add(canvas);

        stage.setScene(scene);
        stage.show();
    }

    /*private void startGame() {
        var gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
            };
        }
        gameLoop.start();
    }*/

    public static void main(String[] args) {
        launch(args);
    }

}
