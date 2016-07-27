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
    setStepX(-1);
    setStepY(-2);
    move(chessList);
    setStepX(1);
    setStepY(-2);
    move(chessList);
    setStepX(2);
    setStepY(-1);
    move(chessList);
    setStepX(2);
    setStepY(1);
    move(chessList);
    setStepX(1);
    setStepY(2);
    move(chessList);
    setStepX(-1);
    setStepY(2);
    move(chessList);
    setStepX(-2);
    setStepY(-1);
    move(chessList);
    setStepX(-2);
    setStepY(1);
    move(chessList);
    return chessList;
  }

  public void move(List<Chess> chessList) throws CloneNotSupportedException {
    setStepChess(this.copyChess(getX(), getY()));
    if (getStepChess().checkMove()){
      getStepChess().setX(getStepChess().getX() + getStepX());
      getStepChess().setY(getStepChess().getY() + getStepY());
      chessList.add(getStepChess().copyChess(getStepChess().getX(),getStepChess().getY()));
    }
  }
}