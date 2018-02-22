/**
 * Clasa pentru o celula perete
 */
public class WallCell extends Cell{
    /**
     * Constructor pentru celula perete
     * @param string
     * @param row
     * @param col
     */
    public WallCell(String string, int row, int col) {
        this.cell = string;
        this.visited = 0;
        this.setDirCell(row, col);
    }
}
