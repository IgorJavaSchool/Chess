package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.List;

/**
 * Конь
 */
public class Knight extends Chess {


  public Knight(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List<Chess> chessMove(List<Chess> chesses) {
    return null;
  }

  public boolean check(int x, int y) {
    return false;
  }

}