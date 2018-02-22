
public abstract class Cell{
    String cell;
    int visited; //contorizam de cate ori va fi vizitat celula
    Direction current;
    Direction right; //EST
    Direction left; //VEST
    Direction front; //NORD
    Direction back; //SUD

    /**
     * Setam directia de orientare a eroului, stabilindu-i vecinii.
     * Initial acesta este orientat spre Nord.
     * @param row
     * @param col
     */
    public void setDirCell(int row, int col){
        this.current = new Direction(row, col);
        this.right = new Direction(row, col + 1);
        this.left = new Direction(row, col - 1);
        this.front = new Direction(row - 1, col);;
        this.back = new Direction(row + 1, col);
    }

    /**
     * Eroul isi va schimba orientarea spre dreapta, astfel vecinul din:
     * ->dreapta va fi cel din Sud;
     * ->fata va fi cel din Est;
     * ->stanga va fi cel din Nord;
     * ->spate va fi cel din Vest;
     * @param row
     * @param col
     */
    public void goToRight(int row, int col){
        this.current = new Direction(row, col);
        this.right = new Direction(row + 1, col);
        this.left = new Direction(row - 1, col);
        this.front = new Direction(row, col + 1);;
        this.back = new Direction(row, col - 1);
    }

    /**
     * Eroul isi va schimba orientarea spre stanga, astfel vecinul din:
     * ->dreapta va fi cel din Nord;
     * ->fata va fi cel din Vest;
     * ->stanga va fi cel din Sud;
     * ->spate va fi cel din Est;
     * @param row
     * @param col
     */
    public void goToLeft(int row, int col){
        this.current = new Direction(row, col);
        this.right = new Direction(row -  1, col);
        this.left = new Direction(row + 1, col);
        this.front = new Direction(row, col - 1);;
        this.back = new Direction(row, col + 1);
    }

    /**
     * Eroul va merge inainte si isi va pastra orientarea spre Nord
     * @param row
     * @param col
     */
    public void goFront(int row, int col){
        setDirCell(row, col);
    }

    /**
     * Eroul isi va schimba orientarea spre spate, astfel vecinul din:
     * ->dreapta va fi cel din Est;
     * ->fata va fi cel din Sud;
     * ->stanga va fi cel din Vest;
     * ->spate va fi cel din Nord;
     * @param row
     * @param col
     */
    public void goBack(int row, int col){
        this.current = new Direction(row, col);
        this.right = new Direction(row, col - 1);
        this.left = new Direction(row, col + 1);
        this.front = new Direction(row + 1, col);;
        this.back = new Direction(row - 1, col);
    }
}



