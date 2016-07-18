package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.List;

/**
 * Слон
 */
public class Bishop extends Chess {


  public Bishop(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List<Chess> chessMove(List<Chess> chesses) {
    boolean checkPlace = false;
    checkPlace = check(x,y);
    return null;
  }

  public boolean check(int x, int y){
    int step = isFront() == true ? 1 : -1;

    return true;
  }
}