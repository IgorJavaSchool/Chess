package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Слон
 */
public class Bishop extends Chess {


  public Bishop(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {
    this.chessmen = chessmen;
    List<Chess> chessList = new ArrayList<>();
    moveUpLeft(chessList);
    moveUpRight(chessList);
    moveDownRight(chessList);
    moveDownLeft(chessList);
    return chessList;
  }

}