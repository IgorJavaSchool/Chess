package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.List;

/**
 * Король
 */
public class King extends Chess {


  public King(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List<Chess> chessMove(List<Chess> chesses) {
    return null;
  }

  public boolean check(int x, int y) {
    return false;
  }
}