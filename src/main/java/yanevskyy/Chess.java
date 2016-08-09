package yanevskyy;


import java.util.ArrayList;
import java.util.List;

/**
 * Imitations chessman.
 * @author Yanevskyy Igor igor2000@inbox.ru
 * @version 0.1
 */
public abstract class Chess implements ChessAction {
    /*Horizontal coordinates*/
    private int x;
    /*Vertical coordinates*/
    private int y;
    /*One step horizontally*/
    private int stepX;
    /*One step vertically*/
    private int stepY;
    /*White or black*/
    private boolean front;
    /*Chessman name*/
    private String name;
    /*All alive chessmen on the board*/
    private List<Chess> chessmen;
    /*All possible steps for this figure*/
    private Square stepChess;
    /*set parameter figure's life*/
    private boolean alive;
    /*Counts figure's steps*/
    protected int count;



    /**
     * Constructor default.
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
        this.count = 0;
    }

    public Chess(Chess chess) {
        this.x = chess.getX();
        this.y = chess.getY();
        this.front = chess.isFront();
        this.name = chess.toString();
        this.alive = chess.isAlive();
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public List<Chess> getChessmen() {
        return chessmen;
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

    protected Square getStepChess() {
        return stepChess;
    }

    protected void setStepChess(Square stepChess) {
        this.stepChess = stepChess;
    }

    public void setCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ) return false;

        Chess chess = (Chess) o;

        if (getX() != chess.getX()) return false;
        if (getY() != chess.getY()) return false;
        if (isFront() != chess.isFront()) return false;
        if (!getName().equals(chess.getName())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getY();
        result = 31 * result + (isFront() ? 1 : 0);
        result = 31 * result + getName().hashCode();
        return result;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    /**
     * Creates a clone of the caller.
     * @param x Coordinate on X.
     * @param y Coordinate on Y.
     * @return New chess owen's clone.
     * @throws CloneNotSupportedException
     */
//    public Chess copyChess(int x, int y) throws CloneNotSupportedException {
//        Chess chess = (Chess)this.clone();
//        chess.setX(x);
//        chess.setY(y);
//        return chess;
//    }

    /**
     * Checked array with all chessmen. Return true if one chessman have discrepant Front
     * and contains some the coordinate.
     * @param square active chessman.
     * @return true if there is opponent's chessman stand in active chessman's new step.
     */
    protected boolean checkMoveNegativeFront(Square square){
        for (Chess chessFront : getChessmen()) {
            if (chessFront.isFront() != isFront()){
                if (square.getY() == chessFront.getY() && square.getX() == chessFront.getX()){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checked array with all chessmen. Return true if one chessman have some Front
     * and contains some the coordinate.
     * @param square active square.
     * @return true if there is own's chessman stand in active chessman's new step.
     */
    private boolean checkMovePositiveFront(Square square) {
        for (Chess chessFront : getChessmen()) {
            if (chessFront.isFront() == isFront()) {
                if (square.getY() == chessFront.getY() && square.getX() == chessFront.getX()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Add into list steps new step with new coordinates.
     * @param chessList List steps.
     */
    public void move(List<Square> chessList){
        setStepChess(new Square(getX(), getY()));
        while (checkMove()){
            getStepChess().setX(getStepChess().getX() + getStepX());
            getStepChess().setY(getStepChess().getY() + getStepY());
            chessList.add(new Square(getStepChess()));
            if (checkMoveNegativeFront(getStepChess()))
                break;
        }
    }

    /**
     * Checks the possibility of movement chessman within the coordinates
     * @return true if movement possible.
     */
    public boolean checkMove() {
        if (getStepChess().getY() + getStepY() > 7 || getStepChess().getY() + getStepY() < 0)
            return false;
        if (getStepChess().getX() + getStepX() > 7 || getStepChess().getX() + getStepX() < 0)
            return false;
        if (checkMovePositiveFront(new Square(getStepChess().getX() + getStepX() , getStepChess().getY() + getStepY())))
            return false;
        return true;
    }

    /**
     * Return all possible steps. Use only for King and Queen
     * @param chessmen List steps
     * @return array all steps.
     */
    protected List<Square> allStepsChess(List<Chess> chessmen) {
        setChessmen(chessmen);
        List<Square> chessList = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                setStepX(i);
                setStepY(j);
                move(chessList);
            }
        }
        return chessList;

    }

    @Override
    public List<Square> chessMove(List<Chess> chessmen) {
        return allStepsChess(chessmen);
    }
}