package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Ферзь
 */
public class Queen extends Chess {


  public Queen(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {
    this.chessmen = chessmen;
    List<Chess> chessList = new ArrayList<>();
    moveRight(chessList);
    moveLeft(chessList);
    moveDown(chessList);
    moveUp(chessList);
    moveUpLeft(chessList);
    moveUpRight(chessList);
    moveDownRight(chessList);
    moveDownLeft(chessList);
    return chessList;
  }

}