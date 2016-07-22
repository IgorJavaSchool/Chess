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
 * Created by MM on 22.07.2016.
 */
public class BishopTest {
    ChessBoard chessBoard;
    Bishop bishop;
    Pawn pawn;
    Pawn pawn2;
    @Before
    public void setUp() throws Exception {
        chessBoard = new ChessBoard();
        chessBoard.createBoard();
        chessBoard.fillChesses();
        for (Chess chess : chessBoard.getChesses()) {
            if (chess.getY() == 1 && chess.getX() == 1) {
                pawn = (Pawn) chess;
            }
            if (chess.getY() == 0 && chess.getX() == 2)
                bishop = (Bishop) chess;
        }
    }

    @After
    public void tearDown() throws Exception {
        chessBoard.printBoard(chessBoard.getBoard());
    }

    @Test
    public void chessMove() throws Exception {
        pawn.setY(3);
        pawn.setX(1);
        List<Chess> chesses = new ArrayList<>();
        chesses.add(bishop.copyChess(1,1));
        chesses.add(bishop.copyChess(0,2));

        List<Chess> result = bishop.chessMove(chessBoard.getChesses());

        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
        assertEquals(result, chesses);
    }

}