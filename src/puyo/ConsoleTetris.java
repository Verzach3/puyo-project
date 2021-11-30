package puyo;

import java.util.ArrayList;

public class ConsoleTetris {

    int height = 13;
    int width = 6;

    ArrayList<Puyo> markedForDelete = new ArrayList<>();

    // [Y][X]
    Puyo[][] grid = new Puyo[height][width];


    public void demo(){
        fillWithVoid();

        grid[12][1] = new Puyo(0, 1, 12, true);
        grid[12][2] = new Puyo(0, 2, 12, true);
        grid[12][3] = new Puyo(0, 3, 12, true);
        grid[12][4] = new Puyo(0, 4, 12, true);
        grid[11][4] = new Puyo(0, 4, 11, true);
        grid[5][4] = new Puyo(0, 4, 5, true);
        grid[5][3] = new Puyo(0, 3, 5, true);

        display();
        System.out.println(markedForDelete.size());
        checkPuyo();
        System.out.println(markedForDelete.size());
        
        display();
    }

    public void init(){
        fillWithVoid();
    }

    public void display() {

        for (Puyo[] puyos : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print("[");
                System.out.print(puyos[j].getColorAsString());
                System.out.print("]");
            }
            System.out.println("");
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
                    }
                }
            }
        }
    }

    public void checkAllDirections(Puyo cube, Directions direction) {
        Puyo cubeForCheck;

        switch (direction) {
        case UP:
            if (cube.getY() > 0) {
                cubeForCheck = grid[cube.getY() - 1][cube.getX()];
                if (compareCubes(cube, cubeForCheck)) {
                    System.out.println("Up True on: X:" + cube.getX() + " And Y:" + cube.getY());
                    checkOnePuyo(cubeForCheck);
                }
            }

            break;
        case DOWN:
            if (cube.getY() < grid.length - 1) {
                cubeForCheck = grid[cube.getY() + 1][cube.getX()];
                if (compareCubes(cube, cubeForCheck)) {
                    System.out.println("Down True on: X:" + cube.getX() + " And Y:" + cube.getY());
                    checkOnePuyo(cubeForCheck);
                }
            }
            break;
        case LEFT:
            if (cube.getX() > 0) {
                cubeForCheck = grid[cube.getY()][cube.getX() - 1];
                if (compareCubes(cube, cubeForCheck)) {
                    System.out.println("Left True on: X:" + cube.getX() + " And Y:" + cube.getY());
                    checkOnePuyo(cubeForCheck);
                }
            }
            break;
        case RIGHT:
            if (cube.getX() < grid[0].length - 1) {
                cubeForCheck = grid[cube.getY()][cube.getX() + 1];
                if (compareCubes(cube, cubeForCheck)) {
                    System.out.println("Right True on: X:" + cube.getX() + " And Y:" + cube.getY());
                    checkOnePuyo(cubeForCheck);
                }
            }
            break;
        default:
            break;
        }

    }

    public boolean compareCubes(Puyo cube1, Puyo cube2) {
        return cube1.getColorAsString().equals(cube2.getColorAsString());
    }

    public void checkOnePuyo(Puyo cube) {

        if (!markedForDelete.contains(cube) && !cube.getColorAsString().equals("-")) {
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
                checkOnePuyo(puyos[j]);
                if (markedForDelete.size() > 3) {
                    deleteMarked();
                } else {
                    markedForDelete.clear();
                }
            }
        }
    }

}
