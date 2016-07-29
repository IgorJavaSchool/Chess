package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Конь
 */
public class Knight extends Chess {

  public Knight(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {
    setChessmen(chessmen);
    List<Chess> chessList = new ArrayList<>();
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