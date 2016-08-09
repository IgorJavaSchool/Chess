package yanevskyy.figures;

import yanevskyy.Chess;
import yanevskyy.ChessAction;
import yanevskyy.Square;

import java.util.List;

/**
 * Король
 * Imitations chessman King. Makes only one step but in any direction.
 */
public class King extends Chess implements ChessAction {

  /**
   * Constructor default.
   * @param y Vertical coordinates.
   * @param x Horizontal coordinates
   * @param name Chessman's name.
   * @param front Set Chessman's color(White or Black).
   */
  public King(int y, int x, String name, boolean front) {
    super(y, x, name, front);
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