package yanevskyy;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.plugin.javascript.navig.Array;
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
    String[][] board;
    User user = new User(true, "While");
    User user1 = new User(false, "Black");
    ChessBoard chessBoard = new ChessBoard();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        chessBoard.createBoard();
        board = chessBoard.getBoard();
        user.createChess();
        user1.createChess();
        chessBoard.fillChesses();
    }

    @Test
    public void move() throws Exception {
        List<Chess> chessesStep = new ArrayList<>();
        chessesStep.add(new Pawn(5,3, "p", false));
        chessesStep.add(new Pawn(4,3, "p", false));
        String coordinat = "D3";
        Pawn chessActiv = new Pawn(5,3, "p", false);

        Chess result = user1.move(coordinat,chessesStep,new Pawn(6,3, "p", false));

        assertEquals(chessActiv,result);

    }

    @Test
    public void selectChess() throws Exception {
        Rook rook = new Rook(0,0, "R", true);
        Chess chess = user.selectChess("a8");

        assertEquals(rook,chess);

        Pawn pawn = new Pawn(6,3, "p", false);
        chess = user1.selectChess("D2");

        assertEquals(pawn,chess);

        Queen queen = new Queen(7,3, "Q", false);
        chess = user1.selectChess("d1");

        assertEquals(queen,chess);

        Bishop bishop = new Bishop(0,2, "B", true);
        chess = user.selectChess("C8");

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
    public void createChess() throws Exception {

    }

}