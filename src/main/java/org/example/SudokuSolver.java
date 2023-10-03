package org.example;

import java.util.Arrays;
import java.util.ArrayList;


public class SudokuSolver {

    int[][] grid;
    Integer[] possibles = {1,2,3,4,5,6,7,8,9};

    public SudokuSolver(int[][] grid) {
        this.grid = grid;
    }

    public int[][] solve() {
        for (int i = 0; i < 50; i++) {
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    if(grid[x][y] == 0) {
                        ArrayList<Integer> possible = findPossible(x, y);
                        if(possible.size() == 1) {
                            grid[x][y] = possible.get(0);
                        }
                    }
                }
            }
        }

        for (int[] row: grid) {
            for (int val: row) {
                System.out.print(val);
            }
            System.out.println();
        }
        return null;
    }

    public ArrayList<Integer> findPossible(int x, int y) {
        ArrayList<Integer> possible = new ArrayList<Integer>(Arrays.asList(possibles));

        //search row
        int[] row = grid[x];
        for (int i: row) {
            if(possible.contains(i)) {
                possible.remove(possible.indexOf(i));
            }
        }

        //search column
        for(int i = 0; i < 9; i++) {
            if(possible.contains(grid[i][y])) {
                possible.remove(possible.indexOf(grid[i][y]));
            }
        }


        //TODO this dont work
        //search square
        int searchFromX = ((x)/ 3) * 3;
        int searchFromY = ((y)/ 3) * 3;
        for (int i = searchFromX; i < searchFromX + 3; i++) {
            for (int j = searchFromY; j < searchFromY + 3; j++) {
                if(possible.contains(grid[i][j])) {
                    possible.remove(possible.indexOf(grid[i][j]));
                }
            }
        }
        return possible;
    }

}