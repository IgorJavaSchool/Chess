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


  public List<Chess> chessMove() {
    int step = front ? 1 : -1;
    List<Chess> chesses = new ArrayList<>();
    chesses.add(keepChess(this.getX() + step, this.getY() + step));
    chesses.add(keepChess(this.getX(), this.getY() + step));
    chesses.add(keepChess(this.getX() - step, this.getY() + step));
    if (count == 0)
      chesses.add(keepChess(this.getX(), this.getY() + (step + step)));
    count++;
    return chesses;
  }

  public Chess keepChess(int x, int y){
    return new Pawn(y,x, this.name, front);
  }
}