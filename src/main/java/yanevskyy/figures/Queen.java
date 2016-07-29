package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.List;

/**
 * Ферзь
 * Imitations chessman Queen. Makes any steps and any direction.
 */
public class Queen extends Chess {

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
   * @throws CloneNotSupportedException
   */
  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {

    return allStepsChess(chessmen);
  }


}