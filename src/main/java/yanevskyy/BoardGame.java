package yanevskyy;

import java.util.List;

/**
 * Created by MM on 29.07.2016.
 */
public interface BoardGame {
    List<Chess> getChesses();
    void createBoard();
    void printBoard();
    void setActiveChessman(Chess activChessman);
    void setChesses(List<Chess> chess);
    boolean checkMoveChess(Square chessmanMove);
    Chess getActiveChessman();
    void fillChesses();
}
