package lxpnh98.poppop;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

class Player {
    private Point2D position;
    private Image image;
    private boolean goLeft;
    private boolean goRight;
    private Integer currentDirection;

    public Player(double x, double y, String imagePath) {
        position = new Point2D(x, y);
        var classLoader = getClass().getClassLoader();
        var imageUrl = classLoader.getResource(imagePath).toExternalForm();
        image = new Image(imageUrl);
        goLeft = false;
        goRight = false;
        currentDirection = 0;
    }
    public Point2D getPosition() {
        return new Point2D(position.getX(), position.getY());
    }
    public Image getImage() {
        return image;
    }
    public void move() {
        position = position.add(new Point2D(currentDirection, 0));
    }
    public void goLeft() {
        goLeft = true;
        currentDirection = -1;
    }
    public void goRight() {
        goRight = true;
        currentDirection = 1;
    }
    public void stopLeft() {
        goLeft = false;
        currentDirection = goRight == true ? 1 : 0;
    }
    public void stopRight() {
        goRight = false;
        currentDirection = goLeft == true ? -1 : 0;
    }
}
