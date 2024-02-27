package lxpnh98.poppop;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

class Player {
    private Point2D position;
    private Image image;

    public Player(double x, double y, String imagePath) {
        position = new Point2D(x, y);
        var classLoader = getClass().getClassLoader();
        var imageUrl = classLoader.getResource(imagePath).toExternalForm();
        image = new Image(imageUrl);
    }
    public Point2D getPosition() {
        return new Point2D(position.getX(), position.getY());
    }
    public Image getImage() {
        return image;
    }
    public void move(double x, double y) {
        position = position.add(new Point2D(x, y));
    }
}
