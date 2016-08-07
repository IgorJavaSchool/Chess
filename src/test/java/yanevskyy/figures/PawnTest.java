package yanevskyy.figures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yanevskyy.BoardGame;
import yanevskyy.Chess;
import yanevskyy.ChessBoard;
import yanevskyy.Square;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by MM on 06.07.2016.
 */
public class PawnTest {
    BoardGame chessBoard;
    BoardGame chessBoardTest;
    List<Square> result;
    List<Square> chesses;


    /**
     * Crete chessboard, create users and create array chess.
     * @throws Exception
     */
    @Before
    public void addUsers() throws Exception {
        chessBoard = new ChessBoard();
        chessBoard.createBoard();
        chessBoard.fillChesses();
        chessBoardTest = new ChessBoard();
        chessBoardTest.createBoard();
    }

    @After
    public void after() throws Exception{
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString() + "X  " + result.get(i).getX() + "  " + chesses.get(i).getX());
            System.out.println(result.get(i).toString() + "Y  " + result.get(i).getY() + "  " + chesses.get(i).getY());
        }
//        for (int i = 0; i < result.size(); i++) {
//            chessBoardTest.getChesses().add(result.get(i));
//        }
        chessBoardTest.printBoard();
    }

    /**
     * checked moove pawn first step and second step when pawn front = false.
     * @throws Exception
     */
    @Test
    public void chessMoveFrontFalse() throws Exception {
        Chess pawn = new Pawn(6,3, "♟", false);
        chesses = new ArrayList<>();
        chesses.add(new Square(3,4));
        chesses.add(new Square(3,5));
        chessBoard.printBoard();

        result = pawn.chessMove(chessBoard.getChesses());

        assertEquals(result, chesses);
        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
    }

    /**
     * checked moove pawn after first step when pawn front = false.
     */
    @Test
    public void chessMoveFrontFalseSecondStep() throws Exception {
        Chess pawn = new Pawn(6,3, "♟", false);
        chesses = new ArrayList<>();
        chesses.add(new Square(3,5));
        pawn.chessMove(chessBoard.getChesses());
        chessBoard.printBoard();

        result = pawn.chessMove(chessBoard.getChesses());

        assertEquals(result, chesses);
        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
    }

    /**
     * checked moove pawn first step and second step when pawn front = false and the pawn can fight front chess.
     * @throws Exception
     */
    @Test
    public void chessMoveFrontFalseAndFight() throws Exception {
        Chess pawn = new Pawn(6,3, "♟", false);
        chesses = new ArrayList<>();
        chesses.add(new Square(4,5));
        chesses.add(new Square(2,5));
        chesses.add(new Square(3,4));
        chesses.add(new Square(3,5));
        chessBoard.getChesses().get(1).setX(2);
        chessBoard.getChesses().get(1).setY(5);
        chessBoard.getChesses().get(3).setX(4);
        chessBoard.getChesses().get(3).setY(5);
        chessBoard.printBoard();

        result = pawn.chessMove(chessBoard.getChesses());

        assertEquals(result, chesses);
        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
    }

    /**
     * checked moove pawn first step when pawn front = true.
     * @throws Exception
     */
    @Test
    public void chessMoveFrontTrue() throws Exception {
        Chess pawn = new Pawn(1,2, "♟", true);
        chesses = new ArrayList<>();
        chesses.add(new Square(2,3));
        chesses.add(new Square(2,2));
        chessBoard.printBoard();

        result = pawn.chessMove(chessBoard.getChesses());

        assertEquals(result, chesses);

        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
    }

    /**
     * checked moove pawn second step when pawn front = true.
     * @throws Exception
     */
    @Test
    public void chessMoveFrontTrueNextStep() throws Exception {
        Chess pawn = new Pawn(1,2, "♟", true);
        chesses = new ArrayList<>();
        chesses.add(new Square(2,2));
        pawn.chessMove(chessBoard.getChesses());   // first step
        chessBoard.printBoard();

        result = pawn.chessMove(chessBoard.getChesses());

        assertEquals(result, chesses);
        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
    }

    /**
     * checked moove pawn first step and second step when pawn front = true and the pawn can fight front chess.
     * @throws Exception
     */
    @Test
    public void chessMoveFrontTrueAndFight() throws Exception {
        Chess pawn = new Pawn(1,2, "♟", true);
        chesses = new ArrayList<>();
        chesses.add(new Square(3,2));
        chesses.add(new Square(1,2));
        chesses.add(new Square(2,3));
        chesses.add(new Square(2,2));
        chessBoard.getChesses().get(0).setX(3);
        chessBoard.getChesses().get(0).setY(2);
        chessBoard.getChesses().get(2).setX(1);
        chessBoard.getChesses().get(2).setY(2);
        chessBoard.printBoard();

        result = pawn.chessMove(chessBoard.getChesses());

        assertEquals(result, chesses);
        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
    }

    /**
     * checked moove pawn first step and second step when pawn front = true and the pawn can fight front chess.
     * @throws Exception
     */
    @Test
    public void chessMoveFrontTrueAndFight2() throws Exception {
        Chess pawn = new Pawn(1,2, "♟", true);
        chesses = new ArrayList<>();
        chesses.add(new Square(1,2));
        chesses.add(new Square(2,3));
        chesses.add(new Square(2,2));
        chessBoard.getChesses().get(0).setX(2);
        chessBoard.getChesses().get(0).setY(3);
        chessBoard.getChesses().get(2).setX(1);
        chessBoard.getChesses().get(2).setY(2);
        chessBoard.printBoard();

        result = pawn.chessMove(chessBoard.getChesses());

        assertEquals(result, chesses);
        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
    }

}