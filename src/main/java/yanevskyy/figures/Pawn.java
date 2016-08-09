package yanevskyy.figures;

import yanevskyy.Chess;
import yanevskyy.ChessAction;
import yanevskyy.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * Пешка
 * Imitations chessman Pawn. Makes only one step and only forward and fight only diagonally.
 */
public class Pawn extends Chess implements ChessAction {

  /**
   * Constructor default. Set vertical step depending on the figure's front.
   * @param y Vertical coordinates.
   * @param x Horizontal coordinates
   * @param name Chessman's name.
   * @param front Set Chessman's color(White or Black).
   */
  public Pawn(int y, int x, String name, boolean front) {
    super(y, x, name, front);
    setStepY(front ? 1 : -1);
  }



  /**
   * Makes all steps only forward and only diagonally if the cell has opponent's figure.
   * @param chessmen All alive chessmen on the board.
   * @return All possible steps for this figure.
   */
  @Override
  public List<Square> chessMove(List<Chess> chessmen) {
    setChessmen(chessmen);
    List<Square> chessList = new ArrayList<>();
    setStepX(1);
    moveFight(chessList);
    setStepX(-1);
    moveFight(chessList);
    setStepX(0);
    if (getCount() == 0) {
      moveAhead(chessList);
      setStepY(isFront() ? 1 : -1);
    }
    moveAhead(chessList);
    return chessList;
  }

  /**
   * Makes step diagonally if the cell has opponent's figure.
   * @param chessList all possible steps this figure.
   */
  public void moveFight(List<Square> chessList){
    setStepChess(new Square(getX(), getY()));
    getStepChess().setX(getStepChess().getX() + getStepX());
    getStepChess().setY(getStepChess().getY() + getStepY());
    if (checkMoveNegativeFront(getStepChess())){
      chessList.add(new Square(getStepChess()));
    }
  }

  /**
   * Makes step on the one cell and only forward.
   * @param chessList all possible steps this figure.
   */
  public void moveAhead(List<Square> chessList) {
    setStepChess(new Square(getX(), getY()));
    if (count == 0) {
      setStepY(getStepY() + getStepY());
    }
    if (checkMove()) {
      if (!checkMoveNegativeFront(getStepChess())) {
        getStepChess().setX(getStepChess().getX() + getStepX());
        getStepChess().setY(getStepChess().getY() + getStepY());
        chessList.add(new Square(getStepChess()));
      }
    }
  }
}