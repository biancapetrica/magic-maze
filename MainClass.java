import java.util.ArrayList;
import java.util.Stack;

public class MainClass {

    /**
     * Metoda scrie in fisierul writer rezolvarea labirintului pentru taskul 1
     * @param maze labirintul
     * @param writer fisierul de output
     */
    public static void task1(Maze maze, HomeworkWriter writer) {
        Direction start = new Direction(0, 0);
        maze.getEntrance(start); // obtinem pozitia portalului de intrare

        ArrayList<Direction> moves = new ArrayList<>();
        moves = Task1.findPath(maze, start); //determinam drumul eroului
        //afisam lungimea drumului si pe acesta
        writer.println(String.valueOf(moves.size()));
        for(Direction dir : moves)
            writer.println(dir.row + " " + dir.col);
    }

    /**
     * Metoda scrie in fisierul writer rezolvarea labirintului pentru taskul 1
     * @param maze labirintul
     * @param writer fisierul de output
     */
    public static void task2(Maze maze, HomeworkWriter writer) {

        Direction start = new Direction(0, 0);
        maze.getEntrance(start); // obtinem pozitia portalului de intrare

        Stack<Direction> shortestPath = new Stack<>();
        shortestPath = Task2.findShortestPath(maze, start); //calculam cel
                                                            // mai scrurt drum
        //afisam lungimea drumului si pe acesta
        writer.println(String.valueOf(shortestPath.size()));
        while (!shortestPath.isEmpty()){
            Direction path = shortestPath.pop();
            writer.println(path.row + " " + path.col);
        }
    }

    public static void main(String[] args) throws Exception {
        HomeworkReader reader = new HomeworkReader(args[1]);
        HomeworkWriter writer = new HomeworkWriter(args[2]);

        Maze maze = reader.readData();
        if (args[0].equals("1"))
            task1(maze, writer);
        if (args[0].equals("2"))
            task2(maze, writer);
        reader.close();
        writer.close();
    }
}
