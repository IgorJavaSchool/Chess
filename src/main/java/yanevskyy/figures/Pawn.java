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
  }

  /**
   *
   * @param chessmen
   * @return
   * @throws CloneNotSupportedException
     */
  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {
    this.chessmen = chessmen;
    List<Chess> chessList = new ArrayList<>();
    chessList = addChessFrontNegative(chessList, getX() + step, getY() + step);
    chessList = addChessFrontNegative(chessList, getX() - step, getY() + step);
    Chess chessFront = this.copyChess(getX(), getY() + step);
    if (!checkMove(chessFront))
      chessList.add(copyChess(getX(), getY() + step));
    if (count == 0 && (!checkMove(chessFront)))
        chessList.add(copyChess(getX(), getY() + (step + step)));
      count++;
    return chessList;
  }

  /**
   * Checked array with all chessmen. Return true if one chessman contains some the coordinate.
   * @param chess
   * @return
   */
  public boolean checkMove(Chess chess){
    for (Chess chessFront : chessmen) {
        if (chess.getY() == chessFront.getY() && chess.getX() == chessFront.getX()){
          return true;
      }
    }
    return false;
  }
}