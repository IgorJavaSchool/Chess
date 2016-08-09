package yanevskyy;


import java.util.List;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Memento {
    private List<Chess> chesses;
    private Chess activeChesses;

    public Memento(List<Chess> chesses, Chess activeChesses) {
        this.chesses = chesses;
        this.activeChesses = activeChesses;
    }

    public List<Chess> getChesses() {
        return chesses;
    }

    public Chess getActiveChesses() {
        return activeChesses;
    }
}
