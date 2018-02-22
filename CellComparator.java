import java.util.Comparator;

public class CellComparator implements Comparator<Cell> {

    /**
     * Comparator pentru a ordona celulele in functie de care a fost vizitata
     * mai putin
     * @param o1
     * @param o2
     * @return diferenta dintre numarulul de vizite
     */
    @Override
    public int compare(Cell o1, Cell o2) {
            return o1.visited - o2.visited;
    }

}
