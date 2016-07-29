package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Король
 */
public class King extends Chess {


  public King(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {
    setChessmen(chessmen);
    List<Chess> chessList = new ArrayList<>();
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        setStepX(i);
        setStepY(j);
        move(chessList);
      }
    }
    return chessList;
  }

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