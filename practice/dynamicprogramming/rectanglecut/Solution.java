package practice.dynamicprogramming.rectanglecut;

/**
 * Given a rectangle MxN, you can cut the rectangle multiple time by horizontal or
 * vertical to form multiple squares. Find the number of cuts that result in minimum
 * of squares
 */
public class Solution {

    private static void solve(int M, int N){
        int[][] minSquares = new int[M][N];

        // Loop through
        for(int i=0; i < M; i++)
            for(int j=0; j < N; j++){
                if(i==j){
                    minSquares[i][j] = minSquares[j][i] = 1;
                    continue;
                }

                // Cut horizontally.
                int min = (i+1)*(j+1);
                for(int yCut=0; yCut < j; yCut ++){
                    min = Math.min(min, minSquares[i][yCut] + minSquares[i][j-yCut - 1]);
                }

                for(int xCut=0; xCut < i; xCut ++){
                    min = Math.min(min, minSquares[xCut][j] + minSquares[i - xCut - 1][j]);
                }

                minSquares[i][j] = min;
            }

        System.out.println(minSquares[M-1][N-1]);
    }

    public static void main(String[] args) {
        solve(10, 2);
        solve(5, 6);
        solve(8, 6);
    }
}
