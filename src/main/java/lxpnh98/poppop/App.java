package lxpnh98.poppop;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

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
        var imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(200);
        imageView.setY(200);

        var bubble = new Circle(200, 100, 50);

        var root = new Group();
        root.getChildren().add(imageView);
        root.getChildren().add(bubble);

        var scene = new Scene(root, 500, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
