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
public class QueenTest {
    BoardGame chessBoard;
    Chess queen;
    Chess pawn;
    @Before
    public void setUp() throws Exception {
        chessBoard = new ChessBoard();
        chessBoard.createBoard();
        chessBoard.fillChesses();
        for (Chess chess : chessBoard.getChesses()) {
            if (chess.getY() == 1 && chess.getX() == 1) {
                pawn =  chess;
            }
            if (chess.getY() == 7 && chess.getX() == 3)
                queen =  chess;
        }
    }

    @Test
    public void chessMove() throws Exception {
        pawn.setY(3);
        pawn.setX(1);
        queen.setX(2);
        queen.setY(4);
        List<Square> chesses = new ArrayList<>();
        chesses.add(new Square(1,3));
        chesses.add(new Square(1,4));
        chesses.add(new Square(0,4));
        chesses.add(new Square(1,5));
        chesses.add(new Square(2,3));
        chesses.add(new Square(2,2));
        chesses.add(new Square(2,1));
        chesses.add(new Square(2,5));
        chesses.add(new Square(3,3));
        chesses.add(new Square(4,2));
        chesses.add(new Square(5,1));
        chesses.add(new Square(3,4));
        chesses.add(new Square(4,4));
        chesses.add(new Square(5,4));
        chesses.add(new Square(6,4));
        chesses.add(new Square(7,4));
        chesses.add(new Square(3,5));

        List<Square> result = queen.chessMove(chessBoard.getChesses());
        chessBoard.printBoard();

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString() + "X  " + result.get(i).getX() + "  " + chesses.get(i).getX());
            System.out.println(result.get(i).toString() + "Y  " + result.get(i).getY() + "  " + chesses.get(i).getY());
        }

        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());

            assertEquals(result, chesses);
        }

    }

}