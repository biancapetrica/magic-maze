import java.util.*;

public class Task2 {
    /**
     * Construim drumul cel mai scurt utilizant algoritmul BFS.
     * Vom utiliza o coada in care vom adauga toate celule vecine ce sunt
     * accesibile ce vor fi verificate in cautarea drumului spre portalul de
     * iesire, marcand pentru fiecare celula parintele sau.
     *
     * @param maze labirintul
     * @param start intrarea in labirint
     * @return o stiva cu cel mai scurt drum din labirint
     */

    public static Stack<Direction> findShortestPath(Maze maze, Direction start) {
        Cell[][] map = maze.getMap();

        Queue<Direction> path = new LinkedList<>();
        path.add(new Direction(start.row, start.col, null));

        while (!path.isEmpty()){
            //scot cate o celula din coada si o verific
            Direction parent = path.peek();
            Cell cell = map[parent.row][parent.col];

            if (cell instanceof ExitCell) // am gasit iesirea si ma opresc
                                          // din cautare
                break;
            path.remove();
            //verificam daca vecinii celulei curente sunt nevizitati si liberi
            //daca gasim astfel de vecini ii adaugam in coada de verificare
            if (maze.isInMaze(cell.right) && maze.isNotWall(cell.right)) {
                Cell right = map[cell.right.row][cell.right.col];
                if (right.visited == 0){
                    path.add(new Direction(right.current.row, right.current.col,
                            parent));
                    right.visited++; // il marcam ca vizitat
                }
            }
            if (maze.isInMaze(cell.front) && maze.isNotWall(cell.front)) {
                Cell front = map[cell.front.row][cell.front.col];
                if (front.visited == 0){
                    path.add(new Direction(front.current.row, front.current.col,
                            parent));
                    front.visited++; // il marcam ca vizitat
                }
            }
            if (maze.isInMaze(cell.left) && maze.isNotWall(cell.left)) {
                Cell left = map[cell.left.row][cell.left.col];
                if (left.visited == 0){
                    path.add(new Direction(left.current.row, left.current.col,
                            parent));
                    left.visited++; // il marcam ca vizitat
                }
            }
            if (maze.isInMaze(cell.back) && maze.isNotWall(cell.back)) {
                Cell back = map[cell.back.row][cell.back.col];
                if (back.visited == 0){
                    path.add(new Direction(back.current.row, back.current.col,
                            parent));
                    back.visited++; // il marcam ca vizitat
                }
            }
        }
        // Am gasit portalul de iesire si vom construi o stiva cu drumul pana
        // la acesta. Drumul va fi dat de parintele fiecarei celule incepand
        // cu celula de iesire.
        Stack<Direction> shortestPath = new Stack<>();
        Direction parent = path.remove();
        while (parent != null){
            shortestPath.add(parent);
            parent = parent.getParent();
        }
        return shortestPath;
    }

}
