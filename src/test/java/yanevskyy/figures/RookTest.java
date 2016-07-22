package yanevskyy.figures;

import org.junit.Before;
import org.junit.Test;
import yanevskyy.Chess;
import yanevskyy.ChessBoard;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by MM on 21.07.2016.
 */
public class RookTest {
    ChessBoard chessBoard;
    Rook rook;
    Pawn pawn;

    @Before
    public void addUsers() throws Exception {
        chessBoard = new ChessBoard();
        chessBoard.createBoard();
        chessBoard.fillChesses();
        for (Chess chess : chessBoard.getChesses()) {
            if (chess.getY() == 1 && chess.getX() == 0) {
                pawn = (Pawn) chess;
            }
            if (chess.getY() == 0 && chess.getX() == 0)
                rook = (Rook) chess;
        }
    }

    @Test
    public void chessSimpleMove() throws Exception {
        pawn.setY(3);
        pawn.setX(0);
        List<Chess> chesses = new ArrayList<>();
        chesses.add(new Rook(1,0, "R", true));
        chesses.add(new Rook(2,0, "R", true));

        List<Chess> result = rook.chessMove(chessBoard.getChesses());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
        assertEquals(result, chesses);
        chessBoard.printBoard(chessBoard.getBoard());
    }

    @Test
    public void chessMoveAndFight() throws Exception {
        pawn.setY(5);
        pawn.setX(1);
        List<Chess> chesses = new ArrayList<>();
        chesses.add(new Rook(1,0, "R", true));
        chesses.add(new Rook(2,0, "R", true));
        chesses.add(new Rook(3,0, "R", true));
        chesses.add(new Rook(4,0, "R", true));
        chesses.add(new Rook(5,0, "R", true));
        chesses.add(new Rook(6,0, "R", true));

        List<Chess> result = rook.chessMove(chessBoard.getChesses());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
        assertEquals(result, chesses);
        chessBoard.printBoard(chessBoard.getBoard());
    }


    @Test
    public void chessMoveAndFight2() throws Exception {
        pawn.setY(5);
        pawn.setX(1);
        rook.setX(0);
        rook.setY(3);
        List<Chess> chesses = new ArrayList<>();
        chesses.add(new Rook(3,1, "R", true));
        chesses.add(new Rook(3,2, "R", true));
        chesses.add(new Rook(3,3, "R", true));
        chesses.add(new Rook(3,4, "R", true));
        chesses.add(new Rook(3,5, "R", true));
        chesses.add(new Rook(3,6, "R", true));
        chesses.add(new Rook(3,7, "R", true));
        chesses.add(new Rook(4,0, "R", true));
        chesses.add(new Rook(5,0, "R", true));
        chesses.add(new Rook(6,0, "R", true));
        chesses.add(new Rook(2,0, "R", true));
        chesses.add(new Rook(1,0, "R", true));
        chesses.add(new Rook(0,0, "R", true));

        List<Chess> result = rook.chessMove(chessBoard.getChesses());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
        assertEquals(result, chesses);
        chessBoard.printBoard(chessBoard.getBoard());
    }

    @Test
    public void chessMoveAndFight3() throws Exception {
        pawn.setY(3);
        pawn.setX(2);
        rook.setX(0);
        rook.setY(3);
        List<Chess> chesses = new ArrayList<>();
        chesses.add(new Rook(3,1, "R", true));
        chesses.add(new Rook(4,0, "R", true));
        chesses.add(new Rook(5,0, "R", true));
        chesses.add(new Rook(6,0, "R", true));
        chesses.add(new Rook(2,0, "R", true));
        chesses.add(new Rook(1,0, "R", true));
        chesses.add(new Rook(0,0, "R", true));

        List<Chess> result = rook.chessMove(chessBoard.getChesses());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
        assertEquals(result, chesses);
        chessBoard.printBoard(chessBoard.getBoard());
    }

/**
 *
 p  false  0  6
 R  true  0  0
 p  false  1  6
 N  true  1  0
 p  false  2  6
 B  true  2  0
 p  false  3  6
 Q  true  3  0
 p  false  4  6
 K  true  4  0
 p  false  5  6
 B  true  5  0
 p  false  6  6
 N  true  6  0
 p  false  7  6
 R  true  7  0
 R  false  0  7
 p  true  0  1
 N  false  1  7
 p  true  1  1
 B  false  2  7
 p  true  2  1
 Q  false  3  7
 p  true  3  1
 K  false  4  7
 p  true  4  1
 B  false  5  7
 p  true  5  1
 N  false  6  7
 p  true  6  1
 R  false  7  7
 p  true  7  1
 *
 */

}