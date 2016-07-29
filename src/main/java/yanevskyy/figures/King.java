package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.List;

/**
 * Король
 */
public class King extends Chess {


  public King(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List chessMove(List chessmen) throws CloneNotSupportedException {

    return allStepsChess(chessmen);
  }

  @Override
  public void move(List chessList) throws CloneNotSupportedException {
    setStepChess(this.copyChess(getX(), getY()));
    if (getStepChess().checkMove()){
      getStepChess().setX(getStepChess().getX() + getStepX());
      getStepChess().setY(getStepChess().getY() + getStepY());
      chessList.add(getStepChess().copyChess(getStepChess().getX(),getStepChess().getY()));
    }
  }

}