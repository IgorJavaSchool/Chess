package yanevskyy;

import yanevskyy.figures.King;

import java.util.List;

/**
 *
 */
public abstract class Chess implements Cloneable {

    public int x;
    public int y;
    public int step;
    public int countStep;
    public boolean front;
    public String name;
    public List<Chess> chessmen;
    public Chess stepChess;

    /**
     *
     * @param y
     * @param x
     * @param name
     * @param front
     */
    public Chess(int y, int x, String name, boolean front) {
        this.x = x;
        this.y = y;
        this.front = front;
        this.name = name;
        this.alive = true;
        this.step = front ? 1 : -1;
        this.countStep = step;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isFront() {
        return front;
    }

    public void setFront(boolean front) {
        this.front = front;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean alive;

    public abstract List<Chess> chessMove(List<Chess> chessmen) throws CloneNotSupportedException;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chess chess = (Chess) o;

        if (x != chess.x) return false;
        if (y != chess.y) return false;
        if (front != chess.front) return false;
        if (!name.equals(chess.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (front ? 1 : 0);
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Chess copyChess(int x, int y) throws CloneNotSupportedException {
        Chess chess = (Chess)this.clone();
        chess.setX(x);
        chess.setY(y);
        return chess;
    }

    /**
     * Checked array with all chessmen. Return true if one chessman have discrepant Front
     * and contains some the coordinate.
     * @param chess
     * @return
     */
    public boolean checkMoveNegativeFront(Chess chess){
        for (Chess chessFront : chessmen) {
            if (chessFront.isFront() != chess.isFront()){
                if (chess.getY() == chessFront.getY() && chess.getX() == chessFront.getX()){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checked array with all chessmen. Return true if one chessman have some Front
     * and contains some the coordinate.
     * @param chess
     * @return
     */
    public boolean checkMovePositiveFront(Chess chess){
        for (Chess chessFront : chessmen) {
            if (chessFront.isFront() == chess.isFront()){
                if (chess.getY() == chessFront.getY() && chess.getX() == chessFront.getX()){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Add to array a chessman which contain coordinate X and Y and have discrepant Front. Return Array chess.
     * @param chessList
     * @param x
     * @param y
     * @return
     * @throws CloneNotSupportedException
     */
    public List<Chess> addChessFrontNegative(List<Chess> chessList, int x, int y) throws CloneNotSupportedException {
        Chess chess = copyChess(x, y);
        if (checkMoveNegativeFront(chess))
            chessList.add(chess);
        return chessList;
    }

    /**
     * Add to array a chessman which contain coordinate X and Y and have some Front. Return Array chess.
     * @param chessList
     * @param x
     * @param y
     * @return
     * @throws CloneNotSupportedException
     */
    public List<Chess> addChessFrontPositive(List<Chess> chessList, int x, int y) throws CloneNotSupportedException {
        Chess chess = copyChess(x, y);
        if (checkMovePositiveFront(chess))
            chessList.add(chess);
        return chessList;
    }

    /**
     * Checked to coordinate X will be under 7 and more 0
     * @return
     */
    public boolean checkMoveRight() throws CloneNotSupportedException {
        if (getX() + step > 7 || getX() + step < 0) {
            return false;
        }
        if (checkMovePositiveFront(this.copyChess(getX() + step, getY())))
            return false;
        return true;
    }

    /**
     * Checked to coordinate X will be under 7 and more 0
     * @return
     */
    public boolean checkMoveLeft() throws CloneNotSupportedException {
        if (getX() - step > 7 || getX() - step < 0)
            return false;
        if (checkMovePositiveFront(this.copyChess(getX() - step, getY())))
            return false;
        return true;
    }

    /**
     * Checked to coordinate Y will be under 7 and more 0
     * @return
     */
    public boolean checkMoveDown() throws CloneNotSupportedException {
        if (getY() + step > 7 || getY() + step < 0)
            return false;
        if (checkMovePositiveFront(this.copyChess(getX() , getY() + step)))
            return false;
        return true;
    }

    /**
     * Checked to coordinate Y will be under 7 and more 0
     * @return
     */
    public boolean checkMoveUp() throws CloneNotSupportedException {
        if (getY() - step > 7 || getY() - step < 0)
            return false;
        if (checkMovePositiveFront(this.copyChess(getX() , getY() - step)))
            return false;
        return true;
    }

    /**
     * Checked to coordinate X and Y will be under 7 and more 0 and checked chessman which localed in the northwest.
     * @return
     */
    public boolean checkMoveUpLeft() throws CloneNotSupportedException {
        if (getY() - step > 7 || getY() - step < 0)
            return false;
        if (getX() - step > 7 || getX() - step < 0)
            return false;
        if (checkMovePositiveFront(this.copyChess(getX() - step , getY() - step)))
            return false;
        return true;
    }

    /**
     * Checked to coordinate X and Y will be under 7 and more 0 and checked chessman which localed in the northeast.
     * @return
     */
    public boolean checkMoveUpRight() throws CloneNotSupportedException {
        if (getY() - step > 7 || getY() - step < 0)
            return false;
        if (getX() + step > 7 || getX() + step < 0)
            return false;
        if (checkMovePositiveFront(this.copyChess(getX() +step , getY() - step)))
            return false;
        return true;
    }

    /**
     * Checked to coordinate X and Y will be under 7 and more 0 and checked chessman which localed in the southwest.
     * @return
     */
    public boolean checkMoveDownLeft() throws CloneNotSupportedException {
        if (getY() + step > 7 || getY() + step < 0)
            return false;
        if (getX() - step > 7 || getX() - step < 0)
            return false;
        if (checkMovePositiveFront(this.copyChess(getX() - step , getY() + step)))
            return false;
        return true;
    }

    /**
     * Checked to coordinate X and Y will be under 7 and more 0 and checked chessman which localed in the southeast.
     * @return
     */
    public boolean checkMoveDownRight() throws CloneNotSupportedException {
        if (getY() + step > 7 || getY() + step < 0)
            return false;
        if (getX() + step > 7 || getX() + step < 0)
            return false;
        if (checkMovePositiveFront(this.copyChess(getX() + step , getY() + step)))
            return false;
        return true;
    }

    /**
     * Filled Array with steps to Up.
     * @param chessList
     * @throws CloneNotSupportedException
     */
    public void moveUp(List<Chess> chessList) throws CloneNotSupportedException {
        while (checkMoveUp()) {
            stepChess = this.copyChess(getX(), getY() - step);
            chessList.add(stepChess);
            if (checkMoveNegativeFront(stepChess))
                break;
            step = step + countStep;
            if (this instanceof King)
                break;
        }
        this.step = front ? 1 : -1;
    }

    /**
     * Filled Array with steps to Down.
     * @param chessList
     * @throws CloneNotSupportedException
     */
    public void moveDown(List<Chess> chessList) throws CloneNotSupportedException {
        while (checkMoveDown()){
            stepChess = this.copyChess(getX(), getY() + step);
            chessList.add(stepChess);
            if (checkMoveNegativeFront(stepChess))
                break;
            step = step + countStep;
            if (this instanceof King)
                break;
        }
        this.step = front ? 1 : -1;
    }

    /**
     * Filled Array with steps to Right.
     * @param chessList
     * @throws CloneNotSupportedException
     */
    public void moveRight(List<Chess> chessList) throws CloneNotSupportedException {
        while (checkMoveRight()){
            stepChess = this.copyChess(getX() + step, getY());
            chessList.add(stepChess);
            if (checkMoveNegativeFront(stepChess))
                break;
            step = step + countStep;
            if (this instanceof King)
                break;
        }
        this.step = front ? 1 : -1;
    }

    /**
     * Filled Array with steps to Left.
     * @param chessList
     * @throws CloneNotSupportedException
     */
    public void moveLeft(List<Chess> chessList) throws CloneNotSupportedException {
        while (checkMoveLeft()){
            stepChess = this.copyChess(getX() - step, getY());
            chessList.add(stepChess);
            if (checkMoveNegativeFront(stepChess))
                break;
            step = step + countStep;
            if (this instanceof King)
                break;

        }
        this.step = front ? 1 : -1;
    }

    /**
     * Filled Array with steps to Up andLeft.
     * @param chessList
     * @throws CloneNotSupportedException
     */
    public void moveUpLeft(List<Chess> chessList) throws CloneNotSupportedException {
        while (checkMoveUpLeft()){
            stepChess = this.copyChess(getX() - step, getY() - step);
            chessList.add(stepChess);
            if (checkMoveNegativeFront(stepChess))
                break;
            step = step + countStep;
            if (this instanceof King)
                break;
        }
        this.step = front ? 1 : -1;
    }

    /**
     * Filled Array with steps to Up and Right.
     * @param chessList
     * @throws CloneNotSupportedException
     */
    public void moveUpRight(List<Chess> chessList) throws CloneNotSupportedException {
        while (checkMoveUpRight()){
            stepChess = this.copyChess(getX() + step, getY() - step);
            chessList.add(stepChess);
            if (checkMoveNegativeFront(stepChess))
                break;
            step = step + countStep;
            if (this instanceof King)
                break;
        }
        this.step = front ? 1 : -1;
    }

    /**
     * Filled Array with steps to Down and Right.
     * @param chessList
     * @throws CloneNotSupportedException
     */
    public void moveDownRight(List<Chess> chessList) throws CloneNotSupportedException {
        while (checkMoveDownRight()){
            stepChess = this.copyChess(getX() + step, getY() + step);
            chessList.add(stepChess);
            if (checkMoveNegativeFront(stepChess))
                break;
            step = step + countStep;
            if (this instanceof King)
                break;
        }
        this.step = front ? 1 : -1;
    }

    /**
     * Filled Array with steps to Down and Left.
     * @param chessList
     * @throws CloneNotSupportedException
     */
    public void moveDownLeft(List<Chess> chessList) throws CloneNotSupportedException {
        while (checkMoveDownLeft()){
            stepChess = this.copyChess(getX() - step, getY() + step);
            chessList.add(stepChess);
            if (checkMoveNegativeFront(stepChess))
                break;
            step = step + countStep;
            if (this instanceof King)
                break;
        }
        this.step = front ? 1 : -1;
    }

}