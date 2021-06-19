package practice.dynamicprogramming.rutso;

import java.util.Arrays;

/**
 * Given an array of numbers, 7 9 2 5 4 3.
 * Whenever you withdraw a number Y between X and Z, it could be calculated as :  X Y Z -> Y * ( X + Z)
 * Find a strategy that helps to withdraw all the numbers and found the maximum score
 */
public class Solution {

    private static void solve(int array[]){
        int[][] maxScore = new int[array.length][array.length];
        // Initialize
        for(int i=0; i < array.length; i ++)
            Arrays.fill(maxScore[i], 0);

        // If there are 2 dimension DP, always loop with j first
        for(int j=3; j < array.length; j++)
            for(int i=j-2; i >= 0; i--)
                // Checking pointers
                for(int checkPointer=i+1; checkPointer <= j-1; checkPointer++)
                    maxScore[i][j] = Math.max(maxScore[i][j],
                            maxScore[i][checkPointer] + maxScore[checkPointer][j] + array[checkPointer]*(array[i] + array[j]));

        System.out.println(maxScore[0][array.length - 1]);
    }

    public static void main(String[] args) {
        solve(new int[]{7, 9, 2, 5, 4, 3});
    }
}
