
/**
 * Clasa pentru portalul de intrare
 */
public class EntranceCell extends Cell{
    /**
     * Constructor pentru portalul de intrare
     * @param string
     * @param row
     * @param col
     */
    public EntranceCell(String string, int row, int col){
        this.cell = string;
        this.visited = 0;
        this.setDirCell(row, col);
    }
}