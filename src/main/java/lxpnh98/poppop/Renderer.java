package lxpnh98.poppop;

import java.util.ArrayList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import org.dyn4j.dynamics.Body;

class Renderer {
    private Canvas canvas;
    private GraphicsContext gc;
    private ArrayList<Player> players;
    private ArrayList<Body> bubbles;

    public Renderer(Canvas canvas) {
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();
        players = new ArrayList<>();
        bubbles = new ArrayList<>();
    }
    public void render() {
        // background
        gc.setFill(Color.BLUE);
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        for (Player p : players) {
            var position = p.getPosition();
            gc.drawImage(p.getImage(), position.getX(), position.getY());
        }
        for (Body b : bubbles) {
            var position = b.getWorldCenter();
            var radius = b.getFixture(0).getShape().getRadius();
            gc.strokeOval(position.x-radius, position.y-radius, radius*2, radius*2);
        }
    }
    public void addPlayer(Player p) {
        players.add(p);
    }
    public void addBubble(Body b) {
        bubbles.add(b);
    }
}
