package lxpnh98.poppop;

import java.util.ArrayList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Renderer {
    private Canvas canvas;
    private GraphicsContext gc;
    private ArrayList<Player> players;

    public Renderer(Canvas canvas) {
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();
        players = new ArrayList<>();
    }
    public void render() {
        // background
        gc.setFill(Color.BLUE);
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        // player
        for (Player p : players) {
            var position = p.getPosition();
            gc.drawImage(p.getImage(), position.getX(), position.getY());
        }
        // bubble
        gc.strokeOval(200, 100, 100, 100);
    }
    public void addPlayer(Player p) {
        players.add(p);
    }
}
