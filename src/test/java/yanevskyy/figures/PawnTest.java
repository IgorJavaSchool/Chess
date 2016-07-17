package yanevskyy.figures;

import org.junit.Test;
import yanevskyy.Chess;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by MM on 06.07.2016.
 */
public class PawnTest {
    @Test

    public void chessMoveFrontFalse() throws Exception {
        Pawn pawn = new Pawn(6,3, "p", false);
        List<Chess> chesses = new ArrayList<>();
        chesses.add(new Pawn(5,2, "p", false));
        chesses.add(new Pawn(5,3, "p", false));
        chesses.add(new Pawn(5,4, "p", false));
        chesses.add(new Pawn(4,3, "p", false));

        List<Chess> result = pawn.chessMove();

        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }

        chesses = new ArrayList<>();
        chesses.add(new Pawn(5,2, "p", false));
        chesses.add(new Pawn(5,3, "p", false));
        chesses.add(new Pawn(5,4, "p", false));

        result = pawn.chessMove();

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

        List<Chess> result = pawn.chessMove();

        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }

        chesses = new ArrayList<>();
        chesses.add(new Pawn(2,3, "p", true));
        chesses.add(new Pawn(2,2, "p", true));
        chesses.add(new Pawn(2,1, "p", true));

        result = pawn.chessMove();

        for (int i = 0; i < chesses.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());
        }
    }

}