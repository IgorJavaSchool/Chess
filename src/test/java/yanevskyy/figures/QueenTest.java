package yanevskyy.figures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yanevskyy.Chess;
import yanevskyy.ChessBoard;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Y on 23.07.2016.
 */
public class QueenTest {
    ChessBoard chessBoard;
    ChessBoard chessBoardTest;
    Queen queen;
    Pawn pawn;
    @Before
    public void setUp() throws Exception {
        chessBoard = new ChessBoard();
        chessBoardTest = new ChessBoard();
        chessBoard.createBoard();
        chessBoard.fillChesses();
        chessBoardTest.createBoard();
        for (Chess chess : chessBoard.getChesses()) {
            if (chess.getY() == 1 && chess.getX() == 1) {
                pawn = (Pawn) chess;
            }
            if (chess.getY() == 7 && chess.getX() == 3)
                queen = (Queen) chess;
        }
    }
    @After
    public void after() throws Exception{
        chessBoardTest.printBoard();
    }

    @Test
    public void chessMove() throws Exception {
        pawn.setY(3);
        pawn.setX(1);
        queen.setX(2);
        queen.setY(4);
        List<Chess> chesses = new ArrayList<>();
        chesses.add(queen.copyChess(3,4));
        chesses.add(queen.copyChess(4,4));
        chesses.add(queen.copyChess(5,4));
        chesses.add(queen.copyChess(6,4));
        chesses.add(queen.copyChess(7,4));
        chesses.add(queen.copyChess(1,4));
        chesses.add(queen.copyChess(0,4));
        chesses.add(queen.copyChess(2,5));
        chesses.add(queen.copyChess(2,3));
        chesses.add(queen.copyChess(2,2));
        chesses.add(queen.copyChess(2,1));
        chesses.add(queen.copyChess(1,3));
        chesses.add(queen.copyChess(3,3));
        chesses.add(queen.copyChess(4,2));
        chesses.add(queen.copyChess(5,1));
        chesses.add(queen.copyChess(3,5));
        chesses.add(queen.copyChess(1,5));

        List<Chess> result = queen.chessMove(chessBoard.getChesses());
        chessBoard.printBoard();

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString() + "X  " + result.get(i).getX() + "  " + chesses.get(i).getX());
            System.out.println(result.get(i).toString() + "Y  " + result.get(i).getY() + "  " + chesses.get(i).getY());
        }
        for (int i = 0; i < result.size(); i++) {
            chessBoardTest.getChesses().add(result.get(i));
        }

        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());

            assertEquals(result, chesses);
        }

    }

}