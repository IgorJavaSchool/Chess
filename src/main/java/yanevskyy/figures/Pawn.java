package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Пешка
 * Imitations chessman Pawn. Makes only one step and only forward and fight only diagonally.
 */
public class Pawn extends Chess {
  private int count;

  /**
   * Constructor default. Set vertical step depending on the figure's front.
   * @param y Vertical coordinates.
   * @param x Horizontal coordinates
   * @param name Chessman's name.
   * @param front Set Chessman's color(White or Black).
   */
  public Pawn(int y, int x, String name, boolean front) {
    super(y, x, name, front);
    this.count = 0;
    setStepY(front ? 1 : -1);
  }


  public int getCount() {
    return count;
  }

  /**
   * Makes all steps only forward and only diagonally if the cell has opponent's figure.
   * @param chessmen All alive chessmen on the board.
   * @return All possible steps for this figure.
   * @throws CloneNotSupportedException
   */
  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {
    setChessmen(chessmen);
    List<Chess> chessList = new ArrayList<>();
    setStepX(1);
    moveFight(chessList);
    setStepX(-1);
    moveFight(chessList);
    setStepX(0);
    if (getCount() == 0) {
      moveAhead(chessList);
      setStepY(isFront() ? 1 : -1);
    }
    moveAhead(chessList);
    return chessList;
  }

  /**
   * Makes step diagonally if the cell has opponent's figure.
   * @param chessList all possible steps this figure.
   * @throws CloneNotSupportedException
   */
  public void moveFight(List<Chess> chessList) throws CloneNotSupportedException {
    setStepChess(this.copyChess(getX(), getY()));
    getStepChess().setX(getStepChess().getX() + getStepX());
    getStepChess().setY(getStepChess().getY() + getStepY());
    if (checkMoveNegativeFront(getStepChess())){
      chessList.add(getStepChess().copyChess(getStepChess().getX(), getStepChess().getY()));
    }
  }

  /**
   * Makes step on the one cell and only forward.
   * @param chessList all possible steps this figure.
   * @throws CloneNotSupportedException
   */
  public void moveAhead(List<Chess> chessList) throws CloneNotSupportedException {
    setStepChess(this.copyChess(getX(), getY()));
    if (count == 0) {
      setStepY(getStepY() + getStepY());
    }
    if (getStepChess().checkMove()) {
      if (!checkMoveNegativeFront(getStepChess())) {
        getStepChess().setX(getStepChess().getX() + getStepX());
        getStepChess().setY(getStepChess().getY() + getStepY());
        chessList.add(getStepChess().copyChess(getStepChess().getX(), getStepChess().getY()));
        count++;
      }
    }
  }
}