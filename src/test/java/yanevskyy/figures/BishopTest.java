package yanevskyy.figures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yanevskyy.BoardGame;
import yanevskyy.Chess;
import yanevskyy.ChessBoard;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by MM on 22.07.2016.
 */
public class BishopTest {
    BoardGame chessBoard;
    Bishop bishop;
    Pawn pawn;
    BoardGame chessBoardTest;
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
            if (chess.getY() == 7 && chess.getX() == 2)
                bishop = (Bishop) chess;
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
        bishop.setX(1);
        bishop.setY(4);
        chesses = new ArrayList<>();
        chesses.add(bishop.copyChess(0,3));
        chesses.add(bishop.copyChess(0,5));
        chesses.add(bishop.copyChess(2,3));
        chesses.add(bishop.copyChess(3,2));
        chesses.add(bishop.copyChess(4,1));
        chesses.add(bishop.copyChess(2,5));

        chessBoard.printBoard();

        result = bishop.chessMove(chessBoard.getChesses());

        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());

            assertEquals(result, chesses);
        }
    }
}