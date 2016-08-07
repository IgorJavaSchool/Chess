package yanevskyy.figures;

import yanevskyy.Chess;
import yanevskyy.ChessAction;
import yanevskyy.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * Конь
 * Imitations chessman Knight. Makes first part of step on the two cells directly
 * and second one cell to the left or to the right.
 */
public class Knight extends Chess implements ChessAction {

  /**
   * Constructor default.
   * @param y Vertical coordinates.
   * @param x Horizontal coordinates
   * @param name Chessman's name.
   * @param front Set Chessman's color(White or Black).
   */
  public Knight(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  /**
   * Makes all steps first part of step on the two cells directly
   * and second one cell to the left or to the right.
   * @param chessmen All alive chessmen on the board.
   * @return All possible steps for this figure.
   * @throws CloneNotSupportedException
   */
  @Override
  public List<Square> chessMove(List<Chess> chessmen) {
    setChessmen(chessmen);
    List<Square> chessList = new ArrayList<>();
    for (int i = -2; i < 3; i++) {
      if (i == 0) continue;
      for (int j = -2; j < 3; j++) {
        if (j == 0) continue;
        if (Math.abs(i) == Math.abs(j)) continue;
        setStepX(i);
        setStepY(j);
        move(chessList);
      }
    }
    return chessList;
  }

  /**
   * Makes one step in that direction.
   * @param chessList List steps.
   */
  @Override
  public void move(List<Square> chessList) {
    setStepChess(new Square(getX(), getY()));
    if (checkMove()){
      getStepChess().setX(getStepChess().getX() + getStepX());
      getStepChess().setY(getStepChess().getY() + getStepY());
      chessList.add(new Square(getStepChess()));
    }
  }
}