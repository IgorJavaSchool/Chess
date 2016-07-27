package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Ферзь
 */
public class Queen extends Chess {


  public Queen(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {
    setChessmen(chessmen);
    List<Chess> chessList = new ArrayList<>();
    setStepX(1);
    setStepY(0);
    move(chessList);
    setStepX(-1);
    setStepY(0);
    move(chessList);
    setStepX(0);
    setStepY(1);
    move(chessList);
    setStepX(0);
    setStepY(-1);
    move(chessList);
    setStepX(-1);
    setStepY(-1);
    move(chessList);
    setStepX(1);
    setStepY(-1);
    move(chessList);
    setStepX(1);
    setStepY(1);
    move(chessList);
    setStepX(-1);
    setStepY(1);
    move(chessList);
    return chessList;
  }

}