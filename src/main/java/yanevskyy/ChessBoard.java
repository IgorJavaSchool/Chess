package yanevskyy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Used for create and print chessboard. Gets message with coordinate chess from users.
 * @author Yanevskyy Igor igor2000@inbox.ru
 * @version 0.1
 */
public class ChessBoard {
  /**
   *
   */
  private User user1;
  private User user2;
  private User activeUser;
  private String[][]board;
  private int countGame;
  private Chess activeChessman;
  private List<Chess> chesses;
  private List<Chess> chessesAliveFalse;
  private List<Chess> chessSteps;
  private String message;


  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public ChessBoard() {
    this.board = new String[8][8];
    this.user1 = new User(false, "Black");
    this.user2 = new User(true, "White");
    this.countGame = 0;
    this.chesses = new ArrayList<>();
    this.chessesAliveFalse = new ArrayList<>();
    this.chessSteps = new ArrayList<>();
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

  public Chess getActiveChessman() {
    return activeChessman;
  }

  public List<Chess> getChessesAliveFalse() {
    return chessesAliveFalse;
  }

  public void setActiveChessman(Chess activChessman) {
    this.activeChessman = activChessman;
  }

  public List<Chess> getChessSteps() {
    return chessSteps;
  }

  /**
   * Create array 8x8, fills empty squares and "+" with out chess.
   */
  public void createBoard(){
    for (int i = 7; i > -1; i--) {
      for (int j = 7; j > -1; j--) {
        board[i][j] = (i + j) % 2 != 0 ? "\033[30m☐" + "\033[37m" : "☒";
      }
    }
    if (countGame == 0) {
      this.user1.createChess();
      this.user2.createChess();
    }
  }

  /**
   * Print filled chessboard in console.
   */
  public void printBoard(){
    printTopBoard();
    printBodyBoard();
    printBottomBoard();
  }

  /**
   * Print top part chessboard and username in console
   */
  public void printTopBoard(){
    System.out.print(String.format("%-11s%-5s" , "  ", user2.getName()));
    if (chessesAliveFalse.size() > 0) {
      System.out.print(String.format("%-2s%-5s" , "  ", "Destroyed"));
      for (Chess chess : chessesAliveFalse) {
        if (!chess.isFront()){
          System.out.print(String.format("%-1s%-1s" , "  ", "\033[34m" + chess.toString() + "\033[37m"));
        }
      }
    }
    System.out.println();
    System.out.println("  "+" "+"Ⓐ"+" "+"Ⓑ"+" "+"Ⓒ"+" "+"Ⓓ"+" "+"Ⓔ"+" "+"Ⓕ"+" "+"Ⓖ"+" "+"Ⓗ");
    System.out.println(String.format("%-2s%-5s" , "   ","_____________________"));
  }

  /**
   * Print board's body in console.
   */
  public void printBodyBoard(){
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
  }

  /**
   * Print in console bottom part chessboard and username.
   */
  public void printBottomBoard(){
    System.out.println(String.format("%-2s%-5s" , "   ","_____________________"));
    System.out.println("  "+" "+"Ⓐ"+" "+"Ⓑ"+" "+"Ⓒ"+" "+"Ⓓ"+" "+"Ⓔ"+" "+"Ⓕ"+" "+"Ⓖ"+" "+"Ⓗ");
    System.out.print(String.format("%-11s%-5s" , "  ",user1.getName()));
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

  /**
   * Write message in console
   * @param message
   */
  public void writeMessage(String message){
    System.out.println(message);
  }

  /**
   * Gets message from user
   * @return
   */
  public String readMessage(){
    try {
      return reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }

  /**
   * Starts game, selects user for move and said user moves.
   */
  public void startGame() throws CloneNotSupportedException {
    while (!user1.isWin() && !user2.isWin()){
      createBoard();
      fillChesses();
      printBoard();
      activeUser = countGame % 2 != 0 ? user1 : user2;
      writeMessage(activeUser.getName() + " to move");
      setActiveChessman(null);
      selectChess();
      if (message.equals("exit")){
        activeUser.setWin(true);
        writeMessage(activeUser.getName() + " has lost");
        break;
      }
      moveChess(chessSteps);
      countGame++;
    }
  }

  /**
   * Gets from user message with coordinate and finds chessman by them.
     */
  public void selectChess(){
    while (true) {
        try {
          if (activeUser.checkShah(getChesses())){
            writeMessage("\033[32mYou SHAH"+ "\033[37m");
          }
          writeMessage("Select chessman");
          message = readMessage();
          if (message.equals("exit")){
            break;
          }
          setActiveChessman(activeUser.selectChess(message, chesses));
          if(getActiveChessman() != null){
            chessSteps = getActiveChessman().chessMove(chesses);
            if (chessSteps.isEmpty()){
              writeMessage("The chessman can't move");
            } else {
              return;
            }
          }
          else writeMessage("The square is not contain your chess");
        } catch (Exception e) {
          writeMessage("This data is not correct");
        }
      }
  }

  /**
   * Gets from user new coordinate for move. If array chessSteps contain figure
   * with new coordinate, move the figure to new place.
   * @param chessSteps All possible steps for selected figure.
     */
  public void moveChess(List<Chess> chessSteps){
    Chess chessmanMove;
    while (true){
      try {
        writeMessage("Make a move");
        chessmanMove = activeUser.move(readMessage(), chessSteps, activeChessman);
        if (!chessmanMove.equals(activeChessman)){
          if (!activeUser.checkShahAfterMove(this, chessmanMove)) {
            if (checkMoveChess(chessmanMove)) {
              activeChessman.setY(chessmanMove.getY());
              activeChessman.setX(chessmanMove.getX());
              break;
            }
          } else {
            writeMessage("\033[32mType \"exit\" and give up or make another run." + "\033[37m");
            countGame--;
            break;
          }
        } else writeMessage("Movement in this square is not possible.");
      } catch (Exception e) {
        writeMessage("This data is not correct");
      }
    }
  }

  /**
   * Checked move chessman and if it fight opponent's chessman then
   * opponent's chessman status "Alive = false".
   * @param chessmanMove
   * @return
     */
  public boolean checkMoveChess(Chess chessmanMove){
      for (Chess chess : chesses) {
        if (chess.getX() == chessmanMove.getX() && chess.getY() == chessmanMove.getY()){
          if (chess.isFront() == chessmanMove.isFront()){
            return false;
          } else{
            chess.setAlive(false);
            chessesAliveFalse.add(chess);
            return true;
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
    try {
      chessBoard.startGame();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }
}