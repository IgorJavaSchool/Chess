package yanevskyy.figures;

import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Конь
 */
public class Knight extends Chess {
  int step1;
  int step2;

  public Knight(int y, int x, String name, boolean front) {
    super(y, x, name, front);
    this.step1 = front ? 2 : -2;
    this.step2 = front ? 1 : -1;
  }

  public List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException {
    this.chessmen = chessmen;
    List<Chess> chessList = new ArrayList<>();
    moveUpLeft(chessList);
    moveUpRight(chessList);
    moveUpRight(chessList);
    moveLeftUp(chessList);
    moveLeftDown(chessList);
    moveRigtUp(chessList);
    moveRightDown(chessList);
    moveDownLeft(chessList);
    moveDownRight(chessList);
    return chessList;
  }


  public void moveUpLeft(List<Chess> chessList) throws CloneNotSupportedException {
    if (getX() - step2 > 7 || getX() - step2 < 0) {
      return;
    }
    if (getY() - step1 > 7 || getY() - step1 < 0) {
      return;
    }
    stepChess = this.copyChess(getX() - step2, getY() - step1);
    if (!checkMovePositiveFront(stepChess))
      chessList.add(stepChess);
  }

  public void moveUpRight(List<Chess> chessList) throws CloneNotSupportedException {
    if (getX() + step2 > 7 || getX() + step2 < 0) {
      return;
    }
    if (getY() - step1 > 7 || getY() - step1 < 0) {
      return;
    }
    stepChess = this.copyChess(getX() + step2, getY() - step1);
    if (!checkMovePositiveFront(stepChess))
      chessList.add(stepChess);
  }

  public void moveLeftUp(List<Chess> chessList) throws CloneNotSupportedException {
    if (getX() + step1 > 7 || getX() + step1 < 0) {
      return;
    }
    if (getY() - step2 > 7 || getY() - step2 < 0) {
      return;
    }
    stepChess = this.copyChess(getX() + step1, getY() - step2);
    if (!checkMovePositiveFront(stepChess))
      chessList.add(stepChess);
  }

  public void moveLeftDown(List<Chess> chessList) throws CloneNotSupportedException {
    if (getX() + step1 > 7 || getX() + step1 < 0) {
      return;
    }
    if (getY() + step2 > 7 || getY() + step2 < 0) {
      return;
    }
    stepChess = this.copyChess(getX() + step1, getY() + step2);
    if (!checkMovePositiveFront(stepChess))
      chessList.add(stepChess);
  }

  public void moveRigtUp(List<Chess> chessList) throws CloneNotSupportedException {
    if (getX() - step1 > 7 || getX() - step1 < 0) {
      return;
    }
    if (getY() - step2 > 7 || getY() - step2 < 0) {
      return;
    }
    stepChess = this.copyChess(getX() - step1, getY() - step2);
    if (!checkMovePositiveFront(stepChess))
      chessList.add(stepChess);
  }

  public void moveRightDown(List<Chess> chessList) throws CloneNotSupportedException {
    if (getX() - step1 > 7 || getX() - step1 < 0) {
      return;
    }
    if (getY() + step2 > 7 || getY() + step2 < 0) {
      return;
    }
    stepChess = this.copyChess(getX() - step1, getY() + step2);
    if (!checkMovePositiveFront(stepChess))
      chessList.add(stepChess);
  }

  public void moveDownLeft(List<Chess> chessList) throws CloneNotSupportedException {
    if (getX() - step2 > 7 || getX() - step2 < 0) {
      return;
    }
    if (getY() + step1 > 7 || getY() + step1 < 0) {
      return;
    }
    stepChess = this.copyChess(getX() - step2, getY() + step1);
    if (!checkMovePositiveFront(stepChess))
      chessList.add(stepChess);
  }

  public void moveDownRight(List<Chess> chessList) throws CloneNotSupportedException {
    if (getX() + step2 > 7 || getX() + step2 < 0) {
      return;
    }
    if (getY() + step1 > 7 || getY() + step1 < 0) {
      return;
    }
    stepChess = this.copyChess(getX() + step2, getY() + step1);
    if (!checkMovePositiveFront(stepChess))
      chessList.add(stepChess);
  }
}