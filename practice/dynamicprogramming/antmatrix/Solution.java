package practice.dynamicprogramming.antmatrix;

/**
 * Given MxN table, and the ant at (0,0). Your job is to tell the ant
 * to go to the bottom of the table. On the path, ant could take some
 * food with size K of the cell. Find the maximum size of food the
 * ant could go.
 *
 * Ant only go down or right.
 */
public class Solution {
    private static void solve(int table[][]){
        int [][] maxEatSoFar = new int[table.length][table[0].length];
        maxEatSoFar[0][0] = table[0][0];

        int finalMax = 0;
        for(int i=0; i < table.length; i++)
            for(int j=0; j<table[0].length; j++){
                int left = 0, up = 0;

                if(j-1>= 0)
                    left = maxEatSoFar[i][j-1];
                if(i-1>= 0)
                    up = maxEatSoFar[i-1][i];

                maxEatSoFar[i][j] = Math.max(left, up) + table[i][j];

                // If last line
                if(i == table.length - 1 && maxEatSoFar[i][j] > finalMax)
                    finalMax = maxEatSoFar[i][j];
            }

        System.out.println(finalMax);
    }

    public static void main(String[] args) {
        solve(new int[][]{
                {10, 0, 0, 0, 0, 0},
                {10, 0, 0, 0, 0, 0},
                {0, 10, 10, 10, 0, 0},
                {0, 0, 0, 10, 0, 0},
                {0, 0, 0, 10, 10, 0},
                {0, 0, 0, 0, 10, 0}
        });
    }
}
