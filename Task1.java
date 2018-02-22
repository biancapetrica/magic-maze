import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {

    /**
     * Construim o lista cu toate celulele pe care eroul pe va vizita in
     * cautarea portalului de iesire din labirint.
     *
     * @param maze labirintul
     * @param current intrarea in labirint
     * @return lista cu celule vizitate din labirint
     */

    public static ArrayList<Direction> findPath(Maze maze, Direction current) {

        Cell[][] map = maze.getMap();
        //Initializam lista
        ArrayList<Direction> path = new ArrayList<>();

        if (maze.isInMaze(current)) {
            while (!(map[current.row][current.col] instanceof ExitCell)) {
                //Adaugam celula curenta in lista cu drumul parcurs si
                // marcham celula ca a fost vizitata.
                path.add(current);
                Cell c = map[current.row][current.col];
                c.visited++;

                //Creem o lista cu vecinii liberi ai celului curente cu
                // prioritatile: R, F, L, B si verificam daca vreun vecin
                // este portalul de iesire
                List<Cell> list = new ArrayList<Cell>();
                if (maze.isInMaze(c.right) && maze.isNotWall(c.right)) {
                    //celula din dreapta este libera
                    if (map[c.right.row][c.right.col] instanceof ExitCell) {
                        path.add(c.right);
                        return path; //am gasit iesire
                    }
                    list.add(map[c.right.row][c.right.col]);
                }
                if (maze.isInMaze(c.front) && maze.isNotWall(c.front)) {
                    //celula din fata este libera
                    if (map[c.front.row][c.front.col] instanceof ExitCell) {
                        path.add(c.front);
                        return path; //am gasit iesire
                    }
                    list.add(map[c.front.row][c.front.col]);
                }
                if (maze.isInMaze(c.left) && maze.isNotWall(c.left)) {
                    //celula din stanga este libera
                    if (map[c.left.row][c.left.col] instanceof ExitCell) {
                        path.add(c.left);
                        return path; //am gasit iesire
                    }
                    list.add(map[c.left.row][c.left.col]);
                }
                if (maze.isInMaze(c.back) && maze.isNotWall(c.back)) {
                    //celula din spate este libera
                    if (map[c.back.row][c.back.col] instanceof ExitCell) {
                        path.add(c.back);
                        return path; //am gasit iesire
                    }
                    list.add(map[c.back.row][c.back.col]);
                }
                //Nu am gasit portalul de iesire in nicio directie asa ca vom
                // ordona lista cu Comparatorul CellComparator pentru a o
                // putea alege pe cea mai putin vizitata dintre acestea
                if (!list.isEmpty()) {
                    Collections.sort(list, new CellComparator());
                    //prima celula din lista va fi vizitata de cele mai
                    // putine ori
                    Cell nextCell = list.get(0);
                    //Verificam pozitia celului in functie de pozitia eroului
                    // ca sa putem vedea in ce directie se va duce acesta si
                    // cum si va schimba orientarea
                    if (nextCell.current.col == current.col + 1) {
                        //eroul se duce la dreapta
                        nextCell.goToRight(nextCell.current.row, nextCell
                                .current.col);
                    }

                    if (nextCell.current.col == current.col - 1) {
                        //eroul se duce la stanga
                        nextCell.goToLeft(nextCell.current.row, nextCell
                                .current.col);
                    }

                    if (nextCell.current.row == current.row - 1) {
                        //eroul se duce in fata
                        nextCell.goFront(nextCell.current.row, nextCell
                                .current.col);
                    }

                    if (nextCell.current.row == current.row + 1) {
                        //eroul se duce in spate
                        nextCell.goBack(nextCell.current.row, nextCell
                                .current.col);

                    }
                    current = nextCell.current; //eroul se va muta in
                                                // urmatoarea celula

                }
            }
        }
        return path; //am gasit iesirea
    }

}
