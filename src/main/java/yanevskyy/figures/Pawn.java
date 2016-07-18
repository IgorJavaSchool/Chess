package yanevskyy.figures;

import yanevskyy.Chess;
import yanevskyy.ChessBoard;
import yanevskyy.User;

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

  public List<Chess> chessMove(List<Chess> chesses) {
    this.chesses = chesses;
    int step = front ? 1 : -1;
    List<Chess> chessList = new ArrayList<>();
    chessList = addChess(chessList, this.getX() + step, this.getY() + step);
    chessList = addChess(chessList, this.getX() - step, this.getY() + step);
    chessList.add(keepChess(this.getX(), this.getY() + step));
    if (count == 0)
      chessList.add(keepChess(this.getX(), this.getY() + (step + step)));
    count++;
    return chessList;
  }

  public Chess keepChess(int x, int y){
    return new Pawn(y,x, this.name, front);
  }

  public boolean checkMoove(Chess chess){
    for (Chess chessFront : chesses) {
      if (chessFront.isFront() != chess.isFront()){
        if (chess.getY() == chessFront.getY() && chess.getX() == chessFront.getX()){
          return true;
        }
      }
    }
    return false;
  }

  public List<Chess> addChess(List<Chess> chessList, int x, int y){
    Chess chess = keepChess(x, y);
    if (checkMoove(chess))
      chessList.add(chess);
    return chessList;
  }
}