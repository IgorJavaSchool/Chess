package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Король
 */
public class King extends Chess {


  public King(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {
    this.chessmen = chessmen;
    List<Chess> chessList = new ArrayList<>();
    moveLeft(chessList);
    moveRight(chessList);
    moveDown(chessList);
    moveUp(chessList);
    moveUpLeft(chessList);
    moveUpRight(chessList);
    moveDownRight(chessList);
    moveDownLeft(chessList);
    return chessList;
  }

}