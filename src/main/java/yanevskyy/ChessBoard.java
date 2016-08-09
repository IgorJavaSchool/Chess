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
public class ChessBoard implements BoardGame {
  /*First user*/
  private User user1;
  /*Second user*/
  private User user2;
  /*Active user at this time*/
  private User activeUser;
  /*Array 8x8 imitation chess board*/
  private String[][]board;
  /*The numbers of moves*/
  private int countGame;
  /*Active chessman at this time*/
  private Chess activeChessman;
  /*All alive chessmen on the board*/
  private List<Chess> chesses;
  /*All destroyed chessmen on the board*/
  private List<Chess> chessesAliveFalse;
  /*All possible steps for this figure*/
  private List<Square> chessSteps;
  /*Message in console*/
  private String message;
  /*Pattern memento*/
  CareTaker careTaker;
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  /**
   * Constructor default.
   */
  public ChessBoard() {
    this.board = new String[8][8];
    this.user1 = new User(false, "Black");
    this.user2 = new User(true, "White");
    this.countGame = 0;
    this.chesses = new ArrayList<>();
    this.chessesAliveFalse = new ArrayList<>();
    this.chessSteps = new ArrayList<>();
//    this.originator = new Originator();
    this.careTaker = new CareTaker();
  }

  private User getActiveUser() {
    return activeUser;
  }

  private void setActiveUser(User activeUser) {
    this.activeUser = activeUser;
  }

  private String[][] getBoard() {
    return board;
  }


  private int getCountGame() {
    return countGame;
  }

  private List<Chess> getChessesAliveFalse() {
    return chessesAliveFalse;
  }

  private List<Square> getChessSteps() {
    return chessSteps;
  }

  private void setChessSteps(List<Square> chessSteps) {
    this.chessSteps = chessSteps;
  }

  private String getMessage() {
    return message;
  }

  private void setMessage(String message) {
    this.message = message;
  }

  User getUser1() {
    return user1;
  }
  User getUser2() {
    return user2;
  }
  @Override
  public List<Chess> getChesses() {
    return chesses;
  }
  @Override
  public Chess getActiveChessman() {
    return activeChessman;
  }
  @Override
  public void setActiveChessman(Chess activChessman) {
    this.activeChessman = activChessman;
  }
  @Override
  public void setChesses(List<Chess> chesses) {
    this.chesses = chesses;
  }

  /**
   * Create array 8x8, fills empty squares and "+" with out chess.
   */
  @Override
  public void createBoard(){
    for (int i = 7; i > -1; i--) {
      for (int j = 7; j > -1; j--) {
        getBoard()[i][j] = (i + j) % 2 != 0 ? "\033[30m☐" + "\033[37m" : "☒";
      }
    }
    if (getCountGame() == 0) {
      this.getUser1().createChess();
      this.getUser2().createChess();
    }
  }

  /**
   * Print filled chessboard in console.
   */
  @Override
  public void printBoard(){
    printTopBoard();
    printBodyBoard();
    printBottomBoard();
  }

  /**
   * Print top part chessboard and username in console
   */
  private void printTopBoard(){
    System.out.print(String.format("%-11s%-5s" , "  ", getUser2().getName()));
    if (getChessesAliveFalse().size() > 0) {
      System.out.print(String.format("%-2s%-5s" , "  ", "Destroyed"));
      for (Chess chess : getChessesAliveFalse()) {
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
  private void printBodyBoard(){
    for (int i = 0; i < 8; i++) {
      System.out.print(8 - i + " |");
      step:
      for (int j = 0; j < 8; j++) {
        for (Chess chess : getChesses()) {
          if (chess.getY() == i && chess.getX() == j){
            if (chess.isFront()) {
              System.out.print("\033[30m" + chess.toString() + "\033[37m|");
            } else {
              System.out.print("\033[34m" + chess.toString() + "\033[37m|");
            }
            continue step;
          }
        }
        System.out.print(getBoard()[i][j] + "|");
      }
      System.out.print(" " + (8 - i));
      System.out.println();
    }
  }

  /**
   * Print in console bottom part chessboard and username.
   */
  private void printBottomBoard(){
    System.out.println(String.format("%-2s%-5s" , "   ","_____________________"));
    System.out.println("  "+" "+"Ⓐ"+" "+"Ⓑ"+" "+"Ⓒ"+" "+"Ⓓ"+" "+"Ⓔ"+" "+"Ⓕ"+" "+"Ⓖ"+" "+"Ⓗ");
    System.out.print(String.format("%-11s%-5s" , "  ",getUser1().getName()));
    if (getChessesAliveFalse().size() > 0) {
      System.out.print(String.format("%-2s%-5s" , "  ", "Destroyed"));
      for (Chess chess : getChessesAliveFalse()) {
        if (chess.isFront()){
          System.out.print(String.format("%-1s%-1s" , "  ", "\033[30m" + chess.toString() + "\033[37m"));
        }
      }
    }
    System.out.println();
  }

  /**
   * Write message in console
   * @param message Message for user in console.
   */
  private void writeMessage(String message){
    System.out.println(message);
  }

  /**
   * Gets message from user
   * @return text which write user in console.
   */
  private String readMessage(){
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
  private void startGame() throws CloneNotSupportedException {
    while (!getUser1().isWin() && !getUser2().isWin()){
      createBoard();
      fillChesses();
      printBoard();
      setActiveUser(getCountGame() % 2 != 0 ? getUser1() : getUser2());
      writeMessage(getActiveUser().getName() + " to move");
      setActiveChessman(null);
      selectChess();
      if (getMessage().equals("exit")){
        getActiveUser().setWin(true);
        writeMessage(getActiveUser().getName() + " has lost");
        break;
      }
      moveChess(getChessSteps());
      countGame++;
    }
    try {
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets from user message with coordinate and finds chessman by them.
   */
  private void selectChess(){
    while (true) {
      try {
        if (getActiveUser().checkShah(getChesses())){
          writeMessage("\033[32mYou SHAH"+ "\033[37m");
        }
        writeMessage("Select chessman");
        setMessage(readMessage());
        if (getMessage().equals("exit")){
          break;
        }
        setActiveChessman(getActiveUser().selectChess(getMessage(), getChesses()));
        if(getActiveChessman() != null){
          setChessSteps(getActiveChessman().chessMove(getChesses()));
          if (getChessSteps().isEmpty()){
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
  private void moveChess(List<Square> chessSteps){
    Square chessmanMove;
    while (true){
      try {
        writeMessage("Make a move");
        chessmanMove = getActiveUser().move(readMessage(), chessSteps, getActiveChessman());
        if (chessmanMove.getY() != getActiveChessman().getY() || chessmanMove.getX() != getActiveChessman().getX()){
          save();
          if (!getActiveUser().checkShahAfterMove(chessmanMove)) {
            load();
            if (checkMoveChess(chessmanMove)) {
              getActiveChessman().setY(chessmanMove.getY());
              getActiveChessman().setX(chessmanMove.getX());
              getActiveChessman().setCount();
              break;
            }
          } else {
            load();
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
   * @param chessmanMove copy active figure which contain coordinates new step.
   * @return true if chessmanMove can make run.
   */
  @Override
  public boolean checkMoveChess(Square chessmanMove){
    for (Chess chess : getChesses()) {
      if (chess.getX() == chessmanMove.getX() && chess.getY() == chessmanMove.getY()){
        if (chess.isFront() == getActiveChessman().isFront()){
          return false;
        } else{
          chessFight(chess);
          return true;
        }
      }
    }
    return true;
  }

  /**
   * Fight chess.
   * @param chess Figure which need fight.
     */
  public void chessFight(Chess chess){
    chess.setAlive(false);
    getChessesAliveFalse().add(chess);
  }

  /**
   * Filled array with chessmen which have status "Alive = true"
   */
  @Override
  public void fillChesses(){
    setChesses(new ArrayList<Chess>());
    for (int i = 0; i < 16; i++) {
      if (getUser1().getChess()[i].isAlive()) {
        getChesses().add(getUser1().getChess()[i]);
      }
      if (getUser2().getChess()[i].isAlive()) {
        getChesses().add(getUser2().getChess()[i]);
      }
    }
  }

  /**
   * Restores the saved state of the game.
   */
  public void load(){
    careTaker.LoadState(getActiveUser());
  }

  /**
   * Saves state of the game.
   */
  public void save(){
    careTaker.SaveState(getActiveUser());
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