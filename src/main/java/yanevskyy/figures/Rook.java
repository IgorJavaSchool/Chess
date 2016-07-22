package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Ладья
 */
public class Rook extends Chess {


  public Rook(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {
    this.chessmen = chessmen;
    List<Chess> chessList = new ArrayList<>();
    moveRight(chessList);
    moveLeft(chessList);
    moveDown(chessList);
    moveUp(chessList);
    return chessList;
  }
}