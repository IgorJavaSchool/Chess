package yanevskyy;

import yanevskyy.figures.*;

import java.util.List;

/**
 * Used for imitation actions user.
 * @author Yanevskyy Igor igor2000@inbox.ru
 * @version 0.1
 */
public class User {
    /*All user's chessmen*/
    private Chess[] chess;
    /*White or black*/
    private boolean front;
    /*set parameter User's win*/
    private boolean win;
    /*User name*/
    private String name;
    /*Active chessman at this time*/
    private Chess activeChessman;

    /**
     * Constructor default.
     * @param front User's win
     * @param name User name
     */
    User(boolean front, String name) {
        this.chess = new Chess[16];
        this.front = front;
        this.win = false;
        this.name = name;
    }

    public void setChess(Chess[] chess) {
        this.chess = chess;
    }

    public Chess getActiveChessman() {
        return activeChessman;
    }

    public void setActiveChessman(Chess activeChessman) {
        this.activeChessman = activeChessman;
    }

    public Chess[] getChess() {
        return chess;
    }

    private boolean isFront() {
        return front;
    }

    boolean isWin() {
        return win;
    }

    String getName() {
        return name;
    }

    void setWin(boolean win) {
        this.win = win;
    }

    /**
     * Makes new chessman with coordinates which writes user.
     * @param message from console.
     * @param chessSteps all possible steps active figure.
     * @param activeChessman Active chessman at this time
     * @return Copy active figure with coordinates which writes user.
     * @throws CloneNotSupportedException
     */
    public Square move(String message, List<Square> chessSteps, Chess activeChessman) throws CloneNotSupportedException {
        Square chessmanSquare = new Square(activeChessman.getX(), activeChessman.getY());
        char[] coordinates = message.toCharArray();
        if (coordinates.length == 2) {
            int x = checkLater(String.valueOf(coordinates[0]).toLowerCase());
            int y = 8 - Integer.parseInt(String.valueOf(coordinates[1]));
            for (Square chess :chessSteps) {
                if (chess.getX() == x && chess.getY() == y) {
                    chessmanSquare.setX(x);
                    chessmanSquare.setY(y);
                }
            }
        }
        return chessmanSquare;
    }

    /**
     *
     * @param message from console.
     * @param chessList All alive chessmen on the board.
     * @return User's figure if its coordinates match those that the user wrote.
     */
    Chess selectChess(String message, List<Chess> chessList){
        char[] coordinates = message.toCharArray();
        if (coordinates.length == 2){
            int x = checkLater(String.valueOf(coordinates[0]).toLowerCase());
            int y = 8 - Integer.parseInt(String.valueOf(coordinates[1]));
            for (Chess figure : chessList) {
                if (figure.isFront() == isFront()) {
                    if (figure.getY() == y && figure.getX() == x) {
                        setActiveChessman(figure);
                        return getActiveChessman();
                    }
                }
            }
        } else System.out.println("This data is not correct");
        return getActiveChessman();
    }

    /**
     * Checks the letters from user and number on the board horizontally.
     * @param firstLater Letter which write user.
     * @return number on the board horizontally.
     */
    private int checkLater(String firstLater){
        int firstNumber;
        switch ( firstLater ){
            case "a" : firstNumber = 0;
                break;
            case "b" : firstNumber = 1;
                break;
            case "c" : firstNumber = 2;
                break;
            case "d" : firstNumber = 3;
                break;
            case "e" : firstNumber = 4;
                break;
            case "f" : firstNumber = 5;
                break;
            case "g" : firstNumber = 6;
                break;
            case "h" : firstNumber = 7;
                break;
            default  : firstNumber = -1;
        }
        return firstNumber;
    }

    /**
     * Creates all user's chessmen.
     */
    void createChess(){
        int count = 0;
        int startCreate = (isFront()) ? 0 : 6;
        int endCreate = (isFront()) ? 2 : 8;
        int selectAction = (isFront()) ? 1 : 6;

        for (int i = startCreate; i < endCreate; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == selectAction){
                    getChess()[count] = new Pawn(i, j, "♟", isFront());
                } else {
                    switch ( j ){
                        case 0 :
                        case 7 : getChess()[count] = new Rook(i, j, "♖", isFront());
                            break;
                        case 1 :
                        case 6 : getChess()[count] = new Knight(i, j, "♘", isFront());
                            break;
                        case 2 :
                        case 5 : getChess()[count] = new Bishop(i, j, "♗", isFront());
                            break;
                        case 3 : getChess()[count] = new Queen(i, j, "♕", isFront());
                            break;
                        case 4 : getChess()[count] = new King(i, j, "♔", isFront());
                            break;
                        default:break;
                    }
                }
                count++;
            }
        }
    }

    /**
     * Checks opportunity opponent's figure fights to user's king.
     * @param chesses All alive chessmen on the board.
     * @return true if opponent's figure can fight to user's king.
     */
    boolean checkShah(List<Chess> chesses) {
        Chess myKing = null;
        List<Square> chessSteps;
        for (Chess chess : chesses) {
            if (chess.isFront() == isFront()) {
                if (chess.toString().equals("♔")) {
                    myKing = chess;
                    break;
                }
            }
        }
        if (myKing != null) {
            for (Chess chess : chesses) {
                if (chess.isFront() != isFront() && chess.isAlive()) {
                    chessSteps = chess.chessMove(chesses);
                    for (Square chessFight : chessSteps) {
                        if (chessFight.getX() == myKing.getX() && chessFight.getY() == myKing.getY())
                            return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * User make new step. If after that shah is true for user's king,
     * then user must correct his step or must be lost.
     * @param chessBoard chess board.
     * @param chessMove new step from user.
     * @return true or false
     */
    boolean checkShahAfterMove(BoardGame chessBoard, Square chessMove){
        if (chessBoard.checkMoveChess(chessMove)) {
            chessBoard.getActiveChessman().setY(chessMove.getY());
            chessBoard.getActiveChessman().setX(chessMove.getX());
            if (checkShah(chessBoard.getChesses())) {
                System.out.println("\033[32mYou SHAH" + "\033[37m");
                return true;
            }
        }
        return false;
    }
}