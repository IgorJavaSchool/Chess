package yanevskyy;

import yanevskyy.figures.King;

import java.util.List;

/**
 *
 */
public abstract class Chess implements Cloneable {

    private int x;
    private int y;
    private int step;
    private int stepX;
    private int stepY;
    private boolean front;
    private String name;
    private List<Chess> chessmen;
    private Chess stepChess;

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

    public int getStepX() {
        return stepX;
    }

    public void setStepX(int stepX) {
        this.stepX = stepX;
    }

    public int getStepY() {
        return stepY;
    }

    public void setStepY(int stepY) {
        this.stepY = stepY;
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

    public void setChessmen(List<Chess> chessmen) {
        this.chessmen = chessmen;
    }

    public List<Chess> getChessmen() {
        return chessmen;
    }

    public Chess getStepChess() {
        return stepChess;
    }

    public void setStepChess(Chess stepChess) {
        this.stepChess = stepChess;
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
    public boolean checkMovePositiveFront(Chess chess) {
        for (Chess chessFront : chessmen) {
            if (chessFront.isFront() == chess.isFront()) {
                if (chess.getY() == chessFront.getY() && chess.getX() == chessFront.getX()) {
                    return true;
                }
            }
        }
            return false;
    }


    public void move(List<Chess> chessList) throws CloneNotSupportedException {
        stepChess = this.copyChess(getX(), getY());
        while (stepChess.checkMove()){
            stepChess.setX(stepChess.getX() + stepX);
            stepChess.setY(stepChess.getY() + stepY);
            chessList.add(stepChess.copyChess(stepChess.getX(),stepChess.getY()));
            if (checkMoveNegativeFront(stepChess))
                break;
        }
    }

    public boolean checkMove() throws CloneNotSupportedException {
        if (getY() + stepY > 7 || getY() + stepY < 0)
            return false;
        if (getX() + stepX > 7 || getX() + stepX < 0)
            return false;
        if (checkMovePositiveFront(this.copyChess(getX() + stepX , getY() + stepY)))
            return false;
        return true;
    }
}