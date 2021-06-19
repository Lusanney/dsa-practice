public class TwoRobotsGrid {
    private static int MAX_ROW;
    private static int MAX_COL;

    private static boolean isValid(int x, int col1, int col2){
        return (x >= 0 && x < MAX_ROW) && (col1 >= 0 && col1 < MAX_COL) && (col2 >= 0 && col2 < MAX_COL);
    }

    private static int getMax(int [][] grid, int[][][] cache, int row, int col1, int col2){
        // not valid cell
        if(!isValid(row, col1, col2)) return Integer.MIN_VALUE;

        // if reach the destination
        if(row == MAX_ROW - 1 && col1 == 0 && col2 == MAX_COL - 1)
            // when there is 1 col
            return col1 == col2 ? grid[row][col1] : grid[row][col1] + grid[row][col2];

        // the end of the row but not the destination
        if(row == MAX_ROW - 1) return Integer.MIN_VALUE;

        // If subproblem is already solved
        if(cache[row][col1][col2] != -1) return cache[row][col1][col2];

        // Init ans
        int ans = Integer.MIN_VALUE;

        // If it is same cell, only takes one
        int temp = (col1 == col2) ? grid[row][col1] : grid[row][col1] + grid[row][col2];

        ans = Math.max(ans, temp + getMax(grid, cache, row + 1, col1, col2 - 1));
        ans = Math.max(ans, temp + getMax(grid, cache, row + 1, col1, col2 + 1));
        ans = Math.max(ans, temp + getMax(grid, cache, row + 1, col1, col2));
        ans = Math.max(ans, temp + getMax(grid, cache, row + 1, col1 - 1, col2 - 1));
        ans = Math.max(ans, temp + getMax(grid, cache, row + 1, col1 - 1, col2));
        ans = Math.max(ans, temp + getMax(grid, cache, row + 1, col1 - 1, col2 + 1));
        ans = Math.max(ans, temp + getMax(grid, cache, row + 1, col1 + 1, col2 - 1));
        ans = Math.max(ans, temp + getMax(grid, cache, row + 1, col1 + 1, col2));
        ans = Math.max(ans, temp + getMax(grid, cache, row + 1, col1 + 1, col2 + 1));

        cache[row][col1][col2] = ans;
        return ans;
    }

    public static void solve(int [][] grid){
        MAX_ROW = grid.length;
        MAX_COL = grid[0].length;

        // 2 robots cache
        int [][][] cache = new int[MAX_ROW][MAX_COL][MAX_COL];

        // Prefill
        for(int i=0; i< MAX_ROW; i++){
            for(int j=0; j < MAX_COL; j++){
                for(int k=0; k < MAX_COL; k++)
                    cache[i][j][k] = -1;
            }
        }

        System.out.println(getMax(grid, cache, 0, 0, MAX_COL -1));
    }
}
