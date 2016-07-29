package yanevskyy;

import java.util.List;

/**
 * Created by MM on 29.07.2016.
 */
public interface BoardGam {
    List<Chess> getChesses();
    void createBoard();
    void printBoard();
    void setActiveChessman(Chess activChessman);
    boolean checkMoveChess(Chess chessmanMove);
    Chess getActiveChessman();
    void fillChesses();
}
