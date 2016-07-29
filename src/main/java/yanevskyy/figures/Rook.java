package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Ладья
 */
public class Rook extends Chess {


  public Rook(int y, int x, String name, boolean front) {
    super(y, x, name, front);
  }

  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {
    setChessmen(chessmen);
    List<Chess> chessList = new ArrayList<>();
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if (Math.abs(i) == Math.abs(j)) continue;
        setStepX(i);
        setStepY(j);
        move(chessList);
      }
    }
    return chessList;
  }
}