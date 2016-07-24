package yanevskyy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yanevskyy.figures.Pawn;
import yanevskyy.figures.Queen;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by MM on 24.07.2016.
 */
public class ChessBoardTest {
    ChessBoard chessBoard;
    User user;
    Queen queen;
    Pawn pawn;
    @Before
    public void setUp() throws Exception {
        chessBoard = new ChessBoard();
        chessBoard.createBoard();
        chessBoard.fillChesses();
        user = chessBoard.getUser2();
        for (Chess chess : chessBoard.getChesses()) {
            if (chess.getY() == 1 && chess.getX() == 3) {
                pawn = (Pawn) chess;
            }
            if (chess.getY() == 7 && chess.getX() == 3)
                queen = (Queen) chess;
        }
    }

    @After
    public void tearDown() throws Exception {
        chessBoard.printBoard(chessBoard.getBoard());
    }

    @Test
    public void checkShah() throws Exception {
        pawn.setY(2);
        pawn.setX(3);
        queen.setX(0);
        queen.setY(4);

        boolean result = chessBoard.checkShah(user.isFront());

        assertEquals(result, true);
    }

}