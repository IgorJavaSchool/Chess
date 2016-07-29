package yanevskyy;


import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class Chess implements Cloneable {

    private int x;
    private int y;
    private int stepX;
    private int stepY;
    private boolean front;
    private String name;
    private List<Chess> chessmen;
    private Chess stepChess;

    /**
     *
     * @param y Coordinate figure in array.
     * @param x Coordinate figure in array.
     * @param name Name(Picture) figure
     * @param front White or Black.
     */
    public Chess(int y, int x, String name, boolean front) {
        this.x = x;
        this.y = y;
        this.front = front;
        this.name = name;
        this.alive = true;
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

    protected int getStepX() {
        return stepX;
    }

    protected void setStepX(int stepX) {
        this.stepX = stepX;
    }

    protected int getStepY() {
        return stepY;
    }

    protected void setStepY(int stepY) {
        this.stepY = stepY;
    }

    protected boolean isFront() {
        return front;
    }

    boolean isAlive() {
        return alive;
    }

    void setAlive(boolean alive) {
        this.alive = alive;
    }

    protected void setChessmen(List<Chess> chessmen) {
        this.chessmen = chessmen;
    }

    protected Chess getStepChess() {
        return stepChess;
    }

    protected void setStepChess(Chess stepChess) {
        this.stepChess = stepChess;
    }

    private boolean alive;

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

    /**
     * Creates a clone of the caller.
     * @param x Coordinate on X.
     * @param y Coordinate on Y.
     * @return New chess owen's clone.
     * @throws CloneNotSupportedException
     */
    public Chess copyChess(int x, int y) throws CloneNotSupportedException {
        Chess chess = (Chess)this.clone();
        chess.setX(x);
        chess.setY(y);
        return chess;
    }

    /**
     * Checked array with all chessmen. Return true if one chessman have discrepant Front
     * and contains some the coordinate.
     * @param chess active chessman.
     * @return true if there is opponent's chessman stand in active chessman's new step.
     */
    protected boolean checkMoveNegativeFront(Chess chess){
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
     * @param chess active chessman.
     * @return true if there is own's chessman stand in active chessman's new step.
     */
    private boolean checkMovePositiveFront(Chess chess) {
        for (Chess chessFront : chessmen) {
            if (chessFront.isFront() == chess.isFront()) {
                if (chess.getY() == chessFront.getY() && chess.getX() == chessFront.getX()) {
                    return true;
                }
            }
        }
            return false;
    }

    /**
     * Add into list steps new step with new coordinates.
     * @param chessList List steps.
     * @throws CloneNotSupportedException
     */
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

    /**
     * Checks the possibility of movement chessman within the coordinates
     * @return If movement possible.
     * @throws CloneNotSupportedException
     */
    public boolean checkMove() throws CloneNotSupportedException {
        if (getY() + stepY > 7 || getY() + stepY < 0)
            return false;
        if (getX() + stepX > 7 || getX() + stepX < 0)
            return false;
        if (checkMovePositiveFront(this.copyChess(getX() + stepX , getY() + stepY)))
            return false;
        return true;
    }

    /**
     * Return all possible steps. Use only for King and Queen
     * @param chessmen List steps
     * @return array all steps.
     * @throws CloneNotSupportedException
     */
    protected List<Chess> allStepsChess(List<Chess> chessmen) throws CloneNotSupportedException {
        setChessmen(chessmen);
        List<Chess> chessList = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                setStepX(i);
                setStepY(j);
                move(chessList);
            }
        }
        return chessList;

    }
}