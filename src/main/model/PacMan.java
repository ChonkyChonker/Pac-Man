package model;

import java.util.ArrayList;
import model.Ghost;

public class PacMan {
    private Position body;
    private Direction dir;
    private Position lastBody;

    public PacMan() {
        this.body = new Position(20,16);
        this.dir = Direction.RIGHT;
        lastBody = new Position(20,16);
    }

    public void move() {
        if (dir == Direction.RIGHT) {
            body = new Position(body.getPosX() + 1, body.getPosY());
            lastBody = new Position(body.getPosX() - 1, body.getPosY());
        } else if (dir == Direction.LEFT) {
            body = new Position(body.getPosX() - 1, body.getPosY());
            lastBody = new Position(body.getPosX() + 1, body.getPosY());
        } else if (dir == Direction.UP) {
            body = new Position(body.getPosX(), body.getPosY() - 1);
            lastBody = new Position(body.getPosX(), body.getPosY() + 1);
        } else if (dir == Direction.DOWN) {
            body = new Position(body.getPosX(), body.getPosY() + 1);
            lastBody = new Position(body.getPosX(), body.getPosY() - 1);
        }
    }

    public Position getPos() {
        return body;
    }

    public void setDirection(Direction direction) {
        this.dir = direction;
    }

    public Position getLastBody() {
        return lastBody;
    }

}
