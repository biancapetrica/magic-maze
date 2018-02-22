/**
 * Clasa pentru pozitia fiecarei celule in labirint
 */
public class Direction {
    int row;
    int col;
    Direction parent;

    /**
     * Constructor
     * @param row
     * @param col
     */
    public Direction(int row,int col){
        this.row = row;
        this.col = col;
    }

    /**
     * Constructor
     * @param row
     * @param col
     * @param parent
     */
    public Direction(int row, int col, Direction parent){
        this.row = row;
        this.col = col;
        this.parent = parent;
    }

    /**
     *
     * @return parent
     */
    public Direction getParent() {
        return parent;
    }
}
