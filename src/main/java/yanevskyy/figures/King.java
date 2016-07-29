package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.List;

/**
 * Король
 * Imitations chessman King. Makes only one step but in any direction.
 */
public class King extends Chess {

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
   * Makes steps in any direction.
   * @param chessmen All alive chessmen on the board.
   * @return All possible steps for this figure.
   * @throws CloneNotSupportedException
   */
  @Override
  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {

    return allStepsChess(chessmen);
  }

  /**
   * Makes one step in that direction.
   * @param chessList List steps.
   * @throws CloneNotSupportedException
   */
  @Override
  public void move(List<Chess> chessList) throws CloneNotSupportedException {
    setStepChess(this.copyChess(getX(), getY()));
    if (getStepChess().checkMove()){
      getStepChess().setX(getStepChess().getX() + getStepX());
      getStepChess().setY(getStepChess().getY() + getStepY());
      chessList.add(getStepChess().copyChess(getStepChess().getX(),getStepChess().getY()));
    }
  }

}