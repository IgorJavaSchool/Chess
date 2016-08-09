package yanevskyy;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class CareTaker {
    private Memento memento;

    public void SaveState(Originator originator){
        memento = originator.GetMemento();
    }
    public void LoadState(Originator originator){
        originator.SetMemento(memento);
    }
}
