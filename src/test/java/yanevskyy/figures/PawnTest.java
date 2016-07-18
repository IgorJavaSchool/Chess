package yanevskyy.figures;

import org.junit.Before;
import org.junit.Test;
import yanevskyy.Chess;
import yanevskyy.ChessBoard;
import yanevskyy.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by MM on 06.07.2016.
 */
public class PawnTest {
    ChessBoard chessBoard;
    @Before
    public void addUsers() throws Exception {
        chessBoard = new ChessBoard();
        chessBoard.createBoard();
        chessBoard.fillChesses();
    }

    /**
     * checked moove pawn first step and second step.
     * @throws Exception
     */
    @Test
    public void chessMoveFrontFalse() throws Exception {
        Pawn pawn = new Pawn(6,3, "p", false);
        List<Chess> chesses = new ArrayList<>();
        chesses.add(new Pawn(5,3, "p", false));
        chesses.add(new Pawn(4,3, "p", false));

        List<Chess> result = pawn.chessMove(chessBoard.getChesses());

        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
/**
 * checked moove pawn after first step.
 */
        chesses = new ArrayList<>();
        chesses.add(new Pawn(5,3, "p", false));

        result = pawn.chessMove(chessBoard.getChesses());

        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }

    }

    @Test
    public void chessMoveFrontFalseAndFight() throws Exception {
        Pawn pawn = new Pawn(6,3, "p", false);
        List<Chess> chesses = new ArrayList<>();
        chesses.add(new Pawn(5,3, "p", false));
        chesses.add(new Pawn(5,2, "p", false));
        chesses.add(new Pawn(5,4, "p", false));
        chesses.add(new Pawn(4,3, "p", false));
        chessBoard.getChesses().get(1).setX(2);
        chessBoard.getChesses().get(1).setY(5);
        chessBoard.getChesses().get(3).setX(4);
        chessBoard.getChesses().get(3).setX(5);

        List<Chess> result = pawn.chessMove(chessBoard.getChesses());

        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
    }

    @Test
    public void chessMoveFrontTrue() throws Exception {
        Pawn pawn = new Pawn(1,2, "p", true);
        List<Chess> chesses = new ArrayList<>();
        chesses.add(new Pawn(2,3, "p", true));
        chesses.add(new Pawn(2,2, "p", true));
        chesses.add(new Pawn(2,1, "p", true));
        chesses.add(new Pawn(3,2, "p", true));

        List<Chess> result = pawn.chessMove(chessBoard.getChesses());

        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }

        chesses = new ArrayList<>();
        chesses.add(new Pawn(2,3, "p", true));
        chesses.add(new Pawn(2,2, "p", true));
        chesses.add(new Pawn(2,1, "p", true));

        result = pawn.chessMove(chessBoard.getChesses());

        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
    }

}