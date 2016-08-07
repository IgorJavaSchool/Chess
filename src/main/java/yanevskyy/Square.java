package yanevskyy;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 * Uses for set coordinates.
 */
public class Square {
    /*Horizontal coordinates*/
    private int x;
    /*Vertical coordinates*/
    private int y;

    /**
     * Default constructor.
     * @param x
     * @param y
     */
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Square(Square square) {
        this.x = square.getX();
        this.y = square.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (x != square.x) return false;
        return y == square.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
