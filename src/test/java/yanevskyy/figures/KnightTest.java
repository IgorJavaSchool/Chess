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
 * Created by MM on 24.07.2016.
 */
public class KnightTest {
    BoardGame chessBoard;
    Chess knight;
    Chess pawn;
    BoardGame chessBoardTest;
    List<Square> result;
    List<Square> chesses;

    @Before
    public void setUp() throws Exception {
        chessBoard = new ChessBoard();
        chessBoard.createBoard();
        chessBoard.fillChesses();
        chessBoardTest = new ChessBoard();
        chessBoardTest.createBoard();
        for (Chess chess : chessBoard.getChesses()) {
            if (chess.getY() == 6 && chess.getX() == 0) {
                pawn = (Pawn) chess;
            }
            if (chess.getY() == 7 && chess.getX() == 1)
                knight = (Knight) chess;
        }
    }

    @After
    public void tearDown() throws Exception {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).toString() + "X  " + result.get(i).getX() + "  " + chesses.get(i).getX());
                System.out.println(result.get(i).toString() + "Y  " + result.get(i).getY() + "  " + chesses.get(i).getY());
            }
//            for (int i = 0; i < result.size(); i++) {
//                chessBoardTest.getChesses().add(result.get(i));
//            }
//            chessBoardTest.printBoard();
    }

    @Test
    public void chessMove() throws Exception {
        pawn.setY(5);
        pawn.setX(0);
        knight.setX(1);
        knight.setY(3);
        chesses = new ArrayList<>();
        chesses.add(new Square(0,1));
        chesses.add(new Square(2,1));
        chesses.add(new Square(2,5));
        chesses.add(new Square(3,2));
        chesses.add(new Square(3,4));

        chessBoard.printBoard();


        result = knight.chessMove(chessBoard.getChesses());

        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getX(), chesses.get(i).getX());
            assertEquals(result.get(i).getY(), chesses.get(i).getY());

            assertEquals(result, chesses);
        }
    }

}