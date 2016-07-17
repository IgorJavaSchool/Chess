package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.List;

/**
 * Ладья
 */
public class Rook extends Chess {


  public Rook(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List<Chess> chessMove() {
    return null;
  }

  public boolean check(int x, int y) {
    return false;
  }
}