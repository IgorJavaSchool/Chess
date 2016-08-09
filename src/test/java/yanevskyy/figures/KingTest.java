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
 * Created by Y on 23.07.2016.
 */
public class KingTest {
    BoardGame chessBoard;
    Chess king;
    Chess pawn;
    List<Square> result;
    List<Square> chesses;

    @Before
    public void setUp() throws Exception {
        chessBoard = new ChessBoard();
        chessBoard.createBoard();
        chessBoard.fillChesses();
        for (Chess chess : chessBoard.getChesses()) {
            if (chess.getY() == 1 && chess.getX() == 1) {
                pawn =  chess;
            }
            if (chess.getY() == 7 && chess.getX() == 4)
                king =  chess;
        }
    }

    @After
    public void tearDown() throws Exception {
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString() + "X  " + result.get(i).getX() + "  " + chesses.get(i).getX());
            System.out.println(result.get(i).toString() + "Y  " + result.get(i).getY() + "  " + chesses.get(i).getY());
        }
    }

    @Test
    public void chessMove() throws Exception {
        pawn.setY(3);
        pawn.setX(1);
        king.setX(2);
        king.setY(4);
        chesses = new ArrayList<>();
        chesses.add(new Square(1,3));
        chesses.add(new Square(1,4));
        chesses.add(new Square(1,5));
        chesses.add(new Square(2,3));
        chesses.add(new Square(2,5));
        chesses.add(new Square(3,3));
        chesses.add(new Square(3,4));
        chesses.add(new Square(3,5));
        chessBoard.printBoard();


        result = king.chessMove(chessBoard.getChesses());

        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());

            assertEquals(result, chesses);
        }

    }

}