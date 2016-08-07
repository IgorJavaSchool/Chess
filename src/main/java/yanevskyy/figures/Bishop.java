package yanevskyy.figures;

import yanevskyy.Chess;
import yanevskyy.ChessAction;
import yanevskyy.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * Слон
 * Imitations chessman bishop. Makes steps only diagonally.
 */
public class Bishop extends Chess implements ChessAction {

  /**
   * Constructor default.
   * @param y Vertical coordinates.
   * @param x Horizontal coordinates
   * @param name Chessman's name.
   * @param front Set Chessman's color(White or Black).
   */
  public Bishop(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  /**
   * Makes steps only diagonally.
   * @param chessmen All alive chessmen on the board.
   * @return All possible steps for this figure.
   */
  @Override
  public List<Square> chessMove(List<Chess> chessmen) {
    setChessmen(chessmen);
    List<Square> chessList = new ArrayList<>();
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        setStepX(i);
        setStepY(j);
        move(chessList);
        j++;
      }
      i++;
    }
    return chessList;
  }

}