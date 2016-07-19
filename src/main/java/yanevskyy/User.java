package yanevskyy;

import yanevskyy.figures.*;

import java.util.List;

public class User {

  private Chess[] chess;
  private boolean front;
  private boolean win;
  private String name;

  public User(boolean front, String name) {
    this.chess = new Chess[16];
    this.front = front;
    this.win = false;
    this.name = name;
  }

  public Chess[] getChess() {
    return chess;
  }

  public boolean isFront() {
    return front;
  }

  public boolean isWin() {
    return win;
  }

  public String getName() {
    return name;
  }

  public Chess move(String message, List<Chess> chessSteps, Chess activChessman) throws CloneNotSupportedException {
    Chess chessman = (Chess) activChessman.clone();
    char[] coordinates = message.toCharArray();
    if (coordinates.length == 2) {
      int x = checkLater(String.valueOf(coordinates[0]).toLowerCase());
      int y = 8 - Integer.parseInt(String.valueOf(coordinates[1]));
      for (Chess chess :chessSteps) {
        if (chess.getX() == x && chess.getY() == y) {
          chessman.setX(x);
          chessman.setY(y);
        }
      }
    }
    return chessman;
  }

  public Chess selectChess(String message){
    char[] coordinates = message.toCharArray();
    Chess activChessman = null;
    if (coordinates.length == 2){
      int x = checkLater(String.valueOf(coordinates[0]).toLowerCase());
      int y = 8 - Integer.parseInt(String.valueOf(coordinates[1]));
      for (Chess figure : chess) {
        if (figure.getY() == y && figure.getX() == x){
          activChessman = figure;
          return activChessman;
        }
      }
      System.out.println("The square is not contain your chess");
    } else System.out.println("This data is not correct");
    return activChessman;
  }

  public int checkLater(String firstLater){
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



  public String[][] createChess(String[][] board){
    int count = 0;
    int startCreate = (front) ? 0 : 6;
    int endCreate = (front) ? 2 : 8;
    int selectAction = (front) ? 1 : 6;

    for (int i = startCreate; i < endCreate; i++) {
      for (int j = 0; j < 8; j++) {
        if (i == selectAction){
          chess[count] = new Pawn(i, j, "p", front);
            board[i][j] = chess[count].toString();
        } else {
          switch ( j ){
            case 0 :
            case 7 : chess[count] = new Rook(i, j, "R", front);
              break;
            case 1 :
            case 6 : chess[count] = new Knight(i, j, "N", front);
              break;
            case 2 :
            case 5 : chess[count] = new Bishop(i, j, "B", front);
              break;
            case 3 : chess[count] = new Queen(i, j, "Q", front);
              break;
            case 4 : chess[count] = new King(i, j, "K", front);
              break;
            default:break;
          }
            board[i][j] = chess[count].toString();
        }
        count++;
      }
    }
    return board;
  }

}