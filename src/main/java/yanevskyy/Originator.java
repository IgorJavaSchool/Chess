package yanevskyy;

import java.util.List;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Originator {
    private List<Chess> chesses;
    private  Chess activeChess;

    public List<Chess> getChesses() {
        return chesses;
    }

    public void setChesses(List<Chess> chesses) {
        this.chesses = chesses;
    }

    public Chess getActiveChess() {
        return activeChess;
    }

    public void setActiveChess(Chess activeChess) {
        this.activeChess = activeChess;
    }

    public Memento setToMomento(){
        return new Memento(chesses);
    }

    public Memento setToMomentoFull(){
        return new Memento(chesses, activeChess);

    }


    }
