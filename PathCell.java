/**
 * Clasa pentru o celula libera
 */
public class PathCell extends Cell{
    /**
     * Constructor pentru o celula libere
     * @param string
     * @param row
     * @param col
     */
    public PathCell(String string, int row, int col){
        this.cell = string;
        this.visited = 0;
        this.setDirCell(row, col);
    }
}
