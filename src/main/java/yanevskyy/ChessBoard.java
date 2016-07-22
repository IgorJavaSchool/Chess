package yanevskyy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChessBoard {

  private User user1;
  private User user2;
  private String[][]board;
  private int countGame;
  private Chess activChessman;
  private List<Chess> chesses;
  private List<Chess> chessesAliveFalse;

  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public ChessBoard() {
    this.board = new String[8][8];
    this.user1 = new User(false, "Black");
    this.user2 = new User(true, "White");
    this.countGame = 0;
    this.chesses = new ArrayList<>();
    this.chessesAliveFalse = new ArrayList<>();
  }

  public List<Chess> getChesses() {
    return chesses;
  }

  public User getUser1() {
    return user1;
  }

  public User getUser2() {
    return user2;
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
    if (countGame == 0) {
      this.user1.createChess();
      this.user2.createChess();
    }
  }

  public void printBoard(String[][] board){
    System.out.print(String.format("%-7s%-5s" , "  ", user2.getName()));
    if (chessesAliveFalse.size() > 0) {
      System.out.print(String.format("%-2s%-5s" , "  ", "Destroyed"));
      for (Chess chess : chessesAliveFalse) {
        if (!chess.isFront()){
          System.out.print(String.format("%-1s%-1s" , "  ", "\033[34m" + chess.toString() + "\033[37m"));
        }
      }
    }
    System.out.println();
    System.out.println("  "+" "+"a"+" "+"b"+" "+"c"+" "+"d"+" "+"e"+" "+"f"+" "+"g"+" "+"h");
    System.out.println(String.format("%-2s%-5s" , "   ","---------------"));
    for (int i = 0; i < 8; i++) {
      System.out.print(8 - i + " |");
      step:
      for (int j = 0; j < 8; j++) {
        for (Chess chess : chesses) {
          if (chess.getY() == i && chess.getX() == j){
            if (chess.isFront()) {
              System.out.print("\033[30m" + chess.toString() + "\033[37m|");
            } else {
              System.out.print("\033[34m" + chess.toString() + "\033[37m|");
            }
            continue step;
          }
        }
        System.out.print(board[i][j] + "|");
      }
      System.out.print(" " + (8 - i));
      System.out.println();
    }
    System.out.println(String.format("%-2s%-5s" , "   ","---------------"));
    System.out.println("  "+" "+"a"+" "+"b"+" "+"c"+" "+"d"+" "+"e"+" "+"f"+" "+"g"+" "+"h");
    System.out.print(String.format("%-7s%-5s" , "  ",user1.getName()));
    if (chessesAliveFalse.size() > 0) {
      System.out.print(String.format("%-2s%-5s" , "  ", "Destroyed"));
      for (Chess chess : chessesAliveFalse) {
        if (chess.isFront()){
          System.out.print(String.format("%-1s%-1s" , "  ", "\033[30m" + chess.toString() + "\033[37m"));
        }
      }
    }
    System.out.println();
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
    User user;
    List<Chess> chessSteps;
    while (!user1.isWin() && !user2.isWin()){
      createBoard();
      fillChesses();
      printBoard(board);
      user = countGame % 2 != 0 ? user1 : user2;
      writeMessage(user.getName() + " to move");
      setActivChessman(null);
      while (true) {
        try {
          writeMessage("Select chessman");
          setActivChessman(user.selectChess(readMessage()));

          if(getActivChessman() != null){
            chessSteps = getActivChessman().chessMove(chesses);
            if (chessSteps.isEmpty()){
              writeMessage("The chessman can't move");
            } else {
              break;
            }
          }
          else writeMessage("The square is not contain your chess");
        } catch (Exception e) {
          writeMessage("This data is not correct");
        }
      }
      while (true){
        try {
          writeMessage("Make a move");
          Chess chessmanMove = user.move(readMessage(), chessSteps, activChessman);
          if (!chessmanMove.equals(activChessman)){
            if (checkMoveChess(chessmanMove)){
              activChessman.setY(chessmanMove.getY());
              activChessman.setX(chessmanMove.getX());
              break;
            }
          } else writeMessage("Movement in this square is not possible.");
        } catch (Exception e) {
          writeMessage("This data is not correct");
        }
      }
      countGame++;
    }
  }


  /**
   * Checked move chessman and if it fight opponent's chessman them
   * opponent's chessman status "Alive = false".
   * @param chessActiv
   * @return
     */
  public boolean checkMoveChess(Chess chessActiv){
    if (chessActiv.getX() > 7 || chessActiv.getX() < 0)
      return false;
    if (chessActiv.getY() > 7 || chessActiv.getY() < 0)
      return false;
      for (Chess chess : chesses) {
        if (chess.getX() == chessActiv.getX() && chess.getY() == chessActiv.getY()){
          if (chess.isFront() == chessActiv.isFront()){
            return false;
          } else{
            chess.setAlive(false);
            chessesAliveFalse.add(chess);
          }
        }
      }
    return true;
  }

  /**
   * Filled array with chessmen which have status "Alive = true"
   */
  public void fillChesses(){
    chesses = new ArrayList<>();
    for (int i = 0; i < 16; i++) {
      if (getUser1().getChess()[i].isAlive()) {
        this.chesses.add(getUser1().getChess()[i]);
      }
      if (getUser2().getChess()[i].isAlive()) {
        this.chesses.add(getUser2().getChess()[i]);
      }
    }
  }

  public static void main(String[] args) {
    ChessBoard chessBoard = new ChessBoard();
    chessBoard.startGame();
  }
}