package puyo;

import java.util.ArrayList;

public class PuyoUtil {


    int width = 6;
    int height = 13;

    ArrayList<Puyo> markedForDelete = new ArrayList<>();

    // [Y][X]
    Puyo[][] grid = new Puyo[height][width];


    public void demo() {
        fillWithVoid();

        createPuyoOnGrid(0, 1, 12);
        createPuyoOnGrid(0, 2, 12);
        createPuyoOnGrid(0, 3, 12);
        createPuyoOnGrid(0, 4, 12);
        createPuyoOnGrid(0, 4, 11);
        createPuyoOnGrid(0, 4, 5);
        createPuyoOnGrid(0, 3, 5);
        //
        createPuyoOnGrid(2, 0, 11);
        createPuyoOnGrid(2, 1, 11);
        createPuyoOnGrid(2, 2, 11);
        createPuyoOnGrid(2, 3, 11);
        //
        createPuyoOnGrid(0, 4, 6);
        createPuyoOnGrid(0, 4, 2);
        createPuyoOnGrid(0, 3, 2);
        createPuyoOnGrid(0, 3, 6);

        display();
        System.out.println(markedForDelete.size());
        //checkOnePuyo(grid[5][3]);
        //checkOnePuyo(grid[5][3]);
        checkPuyo();
        System.out.println(markedForDelete.size());

        display();
    }

    public void init() {
        fillWithVoid();
    }

    public void display() {
        int numY = 0;
        int numX = 0;
        for (Puyo[] puyos : grid) {
            for (int i = 0; i < 6; i++) {
                if (numX < 6){
                    System.out.print("  "+numX);
                    numX++;
                }
                if (numX == 6){
                    System.out.println("");
                    numX++;
                }
            }

            for (int j = 0; j < grid[0].length; j++) {

                System.out.print("[");
                System.out.print(puyos[j].getColorAsString());
                System.out.print("]");
            }
            System.out.print(numY);
            numY++;
            System.out.println();
        }

    }

    public void fillWithVoid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = new Puyo(5, j, i, false);
            }
        }
    }

    public void deleteMarked() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (Puyo puyo : markedForDelete) {
                    if (puyo == grid[i][j]) {
                        grid[i][j] = new Puyo(5, grid[i][j].getX(), grid[i][j].getY());
                        System.out.println("Deleted X: " + puyo.getX() + " - Y: " + puyo.getY());
                    }
                }
            }
        }
    }

    public boolean checkAllDirections(Puyo cube, Directions direction) {
        Puyo cubeForCheck;

        switch (direction) {
            case UP:
                System.out.println("Checked UP");
                if (cube.getY() > 0) {
                     cubeForCheck = grid[cube.getY() - 1][cube.getX()];
                    if (compareCubes(cube, cubeForCheck) && cube.getColorAsString().equals("-")) {
                        System.out.println("Up True on: X:" + cube.getX() + " And Y:" + cube.getY());
                        checkOnePuyo(cubeForCheck);
                        return true;
                    } else {
                        return false;
                    }
                }
                break;
            case DOWN:
                System.out.println("Checked DOWN");
                if (cube.getY() < grid.length - 1) {
                    cubeForCheck = grid[cube.getY() + 1][cube.getX()];
                    System.out.println("Checked Y:" + (cube.getY() + 1) + " X:" + cube.getX());
                    if (compareCubes(cube, cubeForCheck) && cube.getColorAsString().equals("-")) {
                        System.out.println("Down True on: X:" + cube.getX() + " And Y:" + cube.getY());
                        checkOnePuyo(cubeForCheck);
                        return true;
                    } else {
                        return false;
                    }
                }
                break;
            case LEFT:
                System.out.println("Checked LEFT");
                if (cube.getX() > 0) {
                    cubeForCheck = grid[cube.getY()][cube.getX() - 1];
                    if (compareCubes(cube, cubeForCheck) && cube.getColorAsString().equals("-")) {
                        System.out.println("Left True on: X:" + cube.getX() + " And Y:" + cube.getY());
                        checkOnePuyo(cubeForCheck);
                        return true;
                    } else {
                        return false;
                    }
                }
                break;
            case RIGHT:
                System.out.println("Checked RIGHT");
                if (cube.getX() < grid[0].length - 1) {
                    cubeForCheck = grid[cube.getY()][cube.getX() + 1];
                    if (compareCubes(cube, cubeForCheck) && !cube.getColorAsString().equals("-")) {
                        System.out.println("Right True on: X:" + cube.getX() + " And Y:" + cube.getY());
                        checkOnePuyo(cubeForCheck);
                        return true;
                    } else {
                        return false;
                    }
                }
                break;
        }
        return false;

    }

    public boolean compareCubes(Puyo cube1, Puyo cube2) {
        return cube1.getColor() == cube2.getColor();
    }


    public void checkOnePuyo(Puyo cube) {


        if (!markedForDelete.contains(cube)) {
            markedForDelete.add(cube);
            checkAllDirections(cube, Directions.UP);
            checkAllDirections(cube, Directions.DOWN);
            checkAllDirections(cube, Directions.LEFT);
            checkAllDirections(cube, Directions.RIGHT);
        }
    }

    public void checkPuyo() {

        for (Puyo[] puyos : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!puyos[j].getColorAsString().equals("-")){

                    checkOnePuyo(puyos[j]);
                if (markedForDelete.size() > 3) {
                    System.out.println("-------------------------Before Delete-------------------");
                    System.out.println("Marked For Delete: " + markedForDelete.size());
                    display();
                    deleteMarked();
                    System.out.println("-------------------------After Delete--------------------");
                    display();

                }
                }else {
                    markedForDelete.clear();
                    System.out.println("======================Cleared for null");
                }
            }

        }
    }

    public Puyo[][] getGrid() {
        return this.grid;
    }

    public void createPuyoOnGrid(int color, int x, int y){
        grid[y][x] = new Puyo(color, x, y);
    }
}
