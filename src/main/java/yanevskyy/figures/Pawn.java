package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Пешка
 */
public class Pawn extends Chess {
  private int count;

  public Pawn(int y, int x, String name, boolean front) {
    super(y, x, name, front);
    this.count = 0;
    setStepY(front ? 1 : -1);
  }

  /**
   *
   * @param chessmen
   * @return
   * @throws CloneNotSupportedException
     */
  public List chessMove(List chessmen) throws CloneNotSupportedException {
    setChessmen(chessmen);
    List chessList = new ArrayList<>();
    setStepX(1);
    moveFight(chessList);
    setStepX(-1);
    moveFight(chessList);
    setStepX(0);
    if (count == 0) {
      moveAhead(chessList);
      setStepY(isFront() ? 1 : -1);
    }
    moveAhead(chessList);
    return chessList;
  }

  public void moveFight(List chessList) throws CloneNotSupportedException {
    setStepChess(this.copyChess(getX(), getY()));
        getStepChess().setX(getStepChess().getX() + getStepX());
    getStepChess().setY(getStepChess().getY() + getStepY());
    if (checkMoveNegativeFront(getStepChess())){
      chessList.add(getStepChess().copyChess(getStepChess().getX(), getStepChess().getY()));
      }
    }

  public void moveAhead(List chessList) throws CloneNotSupportedException {
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