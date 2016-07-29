package yanevskyy.figures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yanevskyy.BoardGam;
import yanevskyy.Chess;
import yanevskyy.ChessBoard;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Y on 23.07.2016.
 */
public class KingTest {
    BoardGam chessBoard;
    Chess king;
    Chess pawn;
    BoardGam chessBoardTest;
    List<Chess> result;
    List<Chess> chesses;

    @Before
    public void setUp() throws Exception {
        chessBoard = new ChessBoard();
        chessBoard.createBoard();
        chessBoard.fillChesses();
        chessBoardTest = new ChessBoard();
        chessBoardTest.createBoard();
        for (Chess chess : chessBoard.getChesses()) {
            if (chess.getY() == 1 && chess.getX() == 1) {
                pawn = (Pawn) chess;
            }
            if (chess.getY() == 7 && chess.getX() == 4)
                king = (King) chess;
        }
    }

    @After
    public void tearDown() throws Exception {
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString() + "X  " + result.get(i).getX() + "  " + chesses.get(i).getX());
            System.out.println(result.get(i).toString() + "Y  " + result.get(i).getY() + "  " + chesses.get(i).getY());
        }
        for (int i = 0; i < result.size(); i++) {
            chessBoardTest.getChesses().add(result.get(i));
        }
        chessBoardTest.printBoard();
    }

    @Test
    public void chessMove() throws Exception {
        pawn.setY(3);
        pawn.setX(1);
        king.setX(2);
        king.setY(4);
        chesses = new ArrayList<>();
        chesses.add(king.copyChess(1,3));
        chesses.add(king.copyChess(1,4));
        chesses.add(king.copyChess(1,5));
        chesses.add(king.copyChess(2,3));
        chesses.add(king.copyChess(2,5));
        chesses.add(king.copyChess(3,3));
        chesses.add(king.copyChess(3,4));
        chesses.add(king.copyChess(3,5));
        chessBoard.printBoard();


        result = king.chessMove(chessBoard.getChesses());

        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());

            assertEquals(result, chesses);
        }

    }

}