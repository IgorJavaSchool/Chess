package yanevskyy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yanevskyy.figures.Bishop;
import yanevskyy.figures.Pawn;
import yanevskyy.figures.Queen;
import yanevskyy.figures.Rook;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by MM on 30.06.2016.
 */
public class UserTest {
    User user = new User(true, "While");
    User user1 = new User(false, "Black");
    ChessBoard chessBoard;
    Queen queen;
    Pawn pawn;
    Pawn pawn2;
    Pawn pawn3;
    Pawn pawn4;
    Rook rook;

    /**
     *
     * @throws Exception
     */
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
            if (chess.getY() == 1 && chess.getX() == 2) {
                pawn2 = (Pawn) chess;
            }
            if (chess.getY() == 1 && chess.getX() == 4) {
                pawn3 = (Pawn) chess;
            }
            if (chess.getY() == 1 && chess.getX() == 5) {
                pawn4 = (Pawn) chess;
            }
            if (chess.getY() == 7 && chess.getX() == 3)
                queen = (Queen) chess;
            if (chess.getY() == 7 && chess.getX() == 7)
                rook = (Rook) chess;
        }
    }
    @After
    public void after() throws Exception{
        chessBoard.printBoard();
    }

    @Test
    public void move() throws Exception {
        List<Square> chessesStep = new ArrayList<>();
        chessesStep.add(new Square(3,5));
        chessesStep.add(new Square(4,3));
        String coordinat = "D3";
        Pawn chessActiv = new Pawn(5,3, "♟", false);

        Square result = user1.move(coordinat,chessesStep,new Pawn(6,3, "♟", false));

        assertEquals(chessActiv.getX(),result.getX());
        assertEquals(chessActiv.getY(),result.getY());

    }

    @Test
    public void selectChess() throws Exception {
        Rook rook = new Rook(0,0, "♖", true);
        Chess chess = user.selectChess("a8", chessBoard.getChesses());

        assertEquals(rook,chess);

        Pawn pawn = new Pawn(6,3, "♟", false);
        chess = user1.selectChess("D2", chessBoard.getChesses());

        assertEquals(pawn,chess);

        Queen queen = new Queen(7,3, "♕", false);
        chess = user1.selectChess("d1", chessBoard.getChesses());

        assertEquals(queen,chess);

        Bishop bishop = new Bishop(0,2, "♗", true);
        chess = user.selectChess("C8", chessBoard.getChesses());

        assertEquals(bishop,chess);


        /**

                White
            a b c d e f g h
            ---------------
         8 |R|N|B|Q|K|B|N|R| 8
         7 |p|p|p|p|p|p|p|p| 7
         6 |+| |+| |+| |+| | 6
         5 | |+| |+| |+| |+| 5
         4 |+| |+| |+| |+| | 4
         3 | |+| |+| |+| |+| 3
         2 |p|p|p|p|p|p|p|p| 2
         1 |R|N|B|Q|K|B|N|R| 1
            ---------------
            a b c d e f g h
                Black
         */


    }

    @Test
    public void checkShah() throws Exception {
        pawn.setY(2);
        pawn.setX(3);
        queen.setX(0);
        queen.setY(4);

        boolean result = user.checkShah(chessBoard.getChesses());

        assertEquals(result, true);
    }

    @Test
    public void checkShahAfterMove() throws Exception {
        pawn.setY(2);
        pawn.setX(3);
        queen.setX(0);
        queen.setY(4);
        user.setActiveChessman(pawn2);
        user.setChesses(chessBoard.getChesses());


        boolean result = user.checkShahAfterMove(new Square(2,2));

        assertEquals(result, false);


    }

    @Test
    public void checkShahAfterMove2() throws Exception {
        pawn3.setY(2);
        pawn3.setX(5);
        queen.setX(0);
        queen.setY(4);
        rook.setY(2);
        rook.setX(4);
        user.setActiveChessman(pawn);
        user.setChesses(chessBoard.getChesses());


        boolean result = user.checkShahAfterMove( new Square(4,2));

        assertEquals(result, true);
    }

    @Test
    public void checkShahAfterMove3() throws Exception {
        pawn3.setY(2);
        pawn3.setX(5);
        queen.setX(0);
        queen.setY(4);
        rook.setY(2);
        rook.setX(4);
        user.setActiveChessman(pawn4);
        user.setChesses(chessBoard.getChesses());


        boolean result = user.checkShahAfterMove( new Square(4,2));

        assertEquals(result, false);
    }

}