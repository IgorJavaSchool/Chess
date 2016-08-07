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

import static org.junit.Assert.assertEquals;

/**
 * Created by MM on 21.07.2016.
 */
public class RookTest {
    BoardGame chessBoard;
    Chess rook;
    Chess pawn;
    BoardGame chessBoardTest;
    List<Square> result;
    List<Square> chesses;

    @Before
    public void addUsers() throws Exception {
        chessBoard = new ChessBoard();
        chessBoard.createBoard();
        chessBoard.fillChesses();
        chessBoardTest = new ChessBoard();
        chessBoardTest.createBoard();
        for (Chess chess : chessBoard.getChesses()) {
            if (chess.getY() == 1 && chess.getX() == 0) {
                pawn = (Pawn) chess;
            }
            if (chess.getY() == 0 && chess.getX() == 0)
                rook = (Rook) chess;
        }
    }

    @After
    public void tearDown() throws Exception {
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString() + "X  " + result.get(i).getX() + "  " + chesses.get(i).getX());
            System.out.println(result.get(i).toString() + "Y  " + result.get(i).getY() + "  " + chesses.get(i).getY());
        }
//        for (int i = 0; i < result.size(); i++) {
//            chessBoardTest.getChesses().add(result.get(i));
//        }
//        chessBoardTest.printBoard();
    }

    @Test
    public void chessSimpleMove() throws Exception {
        pawn.setY(3);
        pawn.setX(0);
        chesses = new ArrayList<>();
        chesses.add(new Square(0,1));
        chesses.add(new Square(0,2));
        chessBoard.printBoard();

        result = rook.chessMove(chessBoard.getChesses());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
        assertEquals(result, chesses);
    }

    @Test
    public void chessMoveAndFight() throws Exception {
        pawn.setY(5);
        pawn.setX(1);
        chesses = new ArrayList<>();
        chesses.add(new Square(0,1));
        chesses.add(new Square(0,2));
        chesses.add(new Square(0,3));
        chesses.add(new Square(0,4));
        chesses.add(new Square(0,5));
        chesses.add(new Square(0,6));
        chessBoard.printBoard();

        result = rook.chessMove(chessBoard.getChesses());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
        assertEquals(result, chesses);
    }


    @Test
    public void chessMoveAndFight2() throws Exception {
        pawn.setY(5);
        pawn.setX(1);
        rook.setX(0);
        rook.setY(3);
        chesses = new ArrayList<>();
        chesses.add(new Square(0,2));
        chesses.add(new Square(0,1));
        chesses.add(new Square(0,0));
        chesses.add(new Square(0,4));
        chesses.add(new Square(0,5));
        chesses.add(new Square(0,6));
        chesses.add(new Square(1,3));
        chesses.add(new Square(2,3));
        chesses.add(new Square(3,3));
        chesses.add(new Square(4,3));
        chesses.add(new Square(5,3));
        chesses.add(new Square(6,3));
        chesses.add(new Square(7,3));
        chessBoard.printBoard();

        result = rook.chessMove(chessBoard.getChesses());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
        assertEquals(result, chesses);
    }

    @Test
    public void chessMoveAndFight3() throws Exception {
        pawn.setY(3);
        pawn.setX(2);
        rook.setX(0);
        rook.setY(3);
        chesses = new ArrayList<>();
        chesses.add(new Square(0,2));
        chesses.add(new Square(0,1));
        chesses.add(new Square(0,0));
        chesses.add(new Square(0,4));
        chesses.add(new Square(0,5));
        chesses.add(new Square(0,6));
        chesses.add(new Square(1,3));
        chessBoard.printBoard();

        result = rook.chessMove(chessBoard.getChesses());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
        assertEquals(result, chesses);
    }

}