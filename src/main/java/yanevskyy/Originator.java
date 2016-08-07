package yanevskyy;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Originator {
    private ChessBoard chessBoard;

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public Memento setToMomento(ChessBoard chessBoard){
        return new Memento(chessBoard);
    }

}
