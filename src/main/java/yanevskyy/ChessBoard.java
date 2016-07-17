package yanevskyy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ChessBoard {

  private User user1;
  private User user2;
  private String[][]board;
  private int countGame;
  private Chess activChessman;
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public ChessBoard() {
    this.board = new String[8][8];
    this.user1 = new User(false, "Black");
    this.user2 = new User(true, "White");
  }

  public String[][] getBoard() {
    return board;
  }

  public int getCountGame() {
    return countGame;
  }

  public Chess getActivChessman() {
    return activChessman;
  }

  public void setActivChessman(Chess activChessman) {
    this.activChessman = activChessman;
  }

  public void createBoard(){
    for (int i = 7; i > -1; i--) {
      for (int j = 7; j > -1; j--) {
        board[i][j] = (i + j) % 2 != 0 ? " " : "+";
      }
    }
    this.user1.createChess(board);
    this.user2.createChess(board);
  }

  public void printBoard(String[][] board){
    System.out.println(String.format("%-7s%-5s" , "  ", user2.getName()));
    System.out.println("  "+" "+"a"+" "+"b"+" "+"c"+" "+"d"+" "+"e"+" "+"f"+" "+"g"+" "+"h");
    System.out.println(String.format("%-2s%-5s" , "   ","---------------"));
    for (int i = 0; i < 8; i++) {
      System.out.print(8 - i + " |");
      for (int j = 0; j < 8; j++) {
        System.out.print(board[i][j] + "|");
      }
      System.out.print(" " + (8 - i));
      System.out.println();
    }
    System.out.println(String.format("%-2s%-5s" , "   ","---------------"));
    System.out.println("  "+" "+"a"+" "+"b"+" "+"c"+" "+"d"+" "+"e"+" "+"f"+" "+"g"+" "+"h");
    System.out.println(String.format("%-7s%-5s" , "  ",user1.getName()));
  }

  public void writeMessage(String message){
    System.out.println(message);
  }

  public String readMessage(){
    try {
      return reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }

  public void startGame(){
    createBoard();
    printBoard(board);
    User user;
    List<Chess> chessSteps;
    while (!user1.isWin() && !user2.isWin()){
      user = countGame % 2 != 0 ? user1 : user2;
      writeMessage(user.getName() + " to move");
      setActivChessman(null);
      while (true) {
        try {
          writeMessage("Select chessman");
          setActivChessman(user.selectChess(readMessage()));
          if(getActivChessman() != null)
          {
            chessSteps = getActivChessman().chessMove();
            break;
          }
          else writeMessage("The square is not contain your chess");
        } catch (Exception e) {
          writeMessage("This data is not correct");
        }
      }
      while (true){
        try {
          writeMessage("Make a move");

        user.move(readMessage(), activChessman, board);
        } catch (Exception e) {
          writeMessage("This data is not correct");
        }
      }
//      countGame++;
    }
  }

  public static void main(String[] args) {
    ChessBoard chessBoard = new ChessBoard();
    chessBoard.startGame();
  }
}