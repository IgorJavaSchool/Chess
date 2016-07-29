package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Слон
 */
public class Bishop extends Chess {


  public Bishop(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List chessMove(List chessmen) throws CloneNotSupportedException {
    setChessmen(chessmen);
    List chessList = new ArrayList<>();
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        setStepX(i);
        setStepY(j);
        move(chessList);
        j++;
      }
      i++;
    }
    return chessList;
  }

}