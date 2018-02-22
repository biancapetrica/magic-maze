/**
 * Clasa pentru portalul de iesire
 */
public class ExitCell extends Cell{
    /**
     * Constructor pentru portalul de iesire
     * @param string
     * @param row
     * @param col
     */
    public ExitCell(String string, int row, int col){
        this.cell = string;
        this.visited = 0;
        this.setDirCell(row, col);
    }
}