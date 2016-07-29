package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.List;

/**
 * Ферзь
 */
public class Queen extends Chess {


  public Queen(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List chessMove(List chessmen) throws CloneNotSupportedException {

      return allStepsChess(chessmen);
    }


}