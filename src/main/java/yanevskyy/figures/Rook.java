package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Ладья
 * Imitations chessman Rook. Makes steps only horizontally or only vertically.
 */
public class Rook extends Chess {

  /**
   * Constructor default.
   * @param y Vertical coordinates.
   * @param x Horizontal coordinates
   * @param name Chessman's name.
   * @param front Set Chessman's color(White or Black).
   */
  public Rook(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  /**
   * Return all possible steps only horizontally and vertically.
   * @param chessmen All alive chessmen on the board.
   * @return All possible steps for this figure.
   * @throws CloneNotSupportedException
   */
  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {
    setChessmen(chessmen);
    List<Chess> chessList = new ArrayList<>();
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if (Math.abs(i) == Math.abs(j)) continue;
        setStepX(i);
        setStepY(j);
        move(chessList);
      }
    }
    return chessList;
  }
}