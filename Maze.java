import java.util.*;


public class Maze {
    private Cell[][] map;
    private int width;
    private int height;

    /**
     * Constructor
     * @param height
     * @param width
     * @param cells
     */
    public Maze(int height, int width, Cell[][] cells ){
        this.height = height;
        this.width = width;
        this.map = cells;
    }

    /**
     *
     * @return maze height
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @return maze width
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @return harta labirintului
     */
    public Cell[][] getMap() {
        return map;
    }

    /**
     * Determina pozitia portalului de intrare in labirint
     * @param start
     */
    public void getEntrance(Direction start){
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++){
                Cell c = this.map[i][j];
                if(c instanceof EntranceCell){
                    start.row = i;
                    start.col = j;
                    break;
                }
            }
        }
    }

    /**
     * Daca in pozitia dir exista un perete se arunca exceptia
     * CannotMoveIntoWallsException
     * @param dir
     * @throws Exception CannotMoveIntoWallsException
     */
    public void checkWall(Direction dir) throws Exception{
        if (map[dir.row][dir.col] instanceof WallCell)
            throw new CannotMoveIntoWallsException();
    }

    /**
     * Daca pozitia dir se afla in afara labirintului se arunca exceptia
     * HeroOutOfGroundException
     * @param dir
     * @throws Exception HeroOutOfGroundException
     */
    public void checkLimits(Direction dir) throws Exception{
        if (dir.row < 0 || dir.row >= this.height || dir.col < 0 || dir.col >=
                this.width)
            throw new HeroOutOfGroundException();
    }

    /**
     * Verific daca pozitia dir se afla in labirint
     * @param dir
     * @return true/false
     */
    public boolean isInMaze(Direction dir){
        try {
            checkLimits(dir);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * Verific daca in pozitia dir se afla in labirint un perete
     * @param dir
     * @return true/false
     */
    public boolean isNotWall(Direction dir) {
        try {
            checkWall(dir);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
