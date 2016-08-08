package yanevskyy;

import java.util.List;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Memento {
    private  List<Chess> chesses;
    private  Chess activeChess;

    public Memento(List<Chess> chesses) {
        this.chesses = chesses;
    }

    public Memento(List<Chess> chesses, Chess activeChess) {
        this.chesses = chesses;
        this.activeChess = activeChess;
    }

    public List<Chess> getChesses() {
        return chesses;
    }

    public Chess getActiveChess() {
        return activeChess;
    }
}
