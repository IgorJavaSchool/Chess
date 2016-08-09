package yanevskyy;


/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Memento {
    private ChessBoard chessBoard;

    public Memento(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }
}
