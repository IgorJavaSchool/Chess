package yanevskyy;

import java.util.List;

/**
 *
 */
public abstract class Chess {

    public int x;
    public int y;
    public boolean front;
    public String name;
    public List<Chess> chesses;

    /**
     *
     * @param y
     * @param x
     * @param name
     * @param front
     */
    public Chess(int y, int x, String name, boolean front) {
        this.x = x;
        this.y = y;
        this.front = front;
        this.name = name;
        this.alive = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isFront() {
        return front;
    }

    public void setFront(boolean front) {
        this.front = front;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean alive;

    public abstract List<Chess> chessMove(List<Chess> chesses);

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chess chess = (Chess) o;

        if (x != chess.x) return false;
        if (y != chess.y) return false;
        if (front != chess.front) return false;
        if (!name.equals(chess.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (front ? 1 : 0);
        result = 31 * result + name.hashCode();
        return result;
    }
}