package yanevskyy;


import java.util.List;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Memento {
    private int x;
    private int y;

    public Memento(Chess chess) {
        this.x = chess.getX();
        this.y = chess.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
