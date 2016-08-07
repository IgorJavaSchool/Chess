package yanevskyy.figures;

import yanevskyy.Chess;
import yanevskyy.ChessAction;

/**
 * Ферзь
 * Imitations chessman Queen. Makes any steps and any direction.
 */
public class Queen extends Chess implements ChessAction {

  /**
   * Constructor default.
   * @param y Vertical coordinates.
   * @param x Horizontal coordinates
   * @param name Chessman's name.
   * @param front Set Chessman's color(White or Black).
   */
  public Queen(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  /**
   * Return all possible steps.
   * @param chessmen All alive chessmen on the board.
   * @return All possible steps for this figure.
   */
//  public List<Square> chessMove(List<Chess> chessmen) {
//
//    return allStepsChess(chessmen);
//  }


}