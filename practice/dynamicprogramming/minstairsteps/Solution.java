package practice.dynamicprogramming.minstairsteps;

/**
 * Given N stairs. Starting from stair 0, how many possible steps
 * that could reach N, knowing you could go 1 or 2 steps per turn.
 */
public class Solution {
    private static void solve(int N){
        int [] minSteps = new int[N];
        minSteps[0] = 1; //Stair 0 only 1 possible way
        minSteps[1] = 2; //Stiar 2 could be 2x1 + 1x2 -> 2 ways

        for(int i=2; i<N; i++)
            minSteps[i] = minSteps[i-1] + minSteps[i-2];

        System.out.println(minSteps[N-1]);
    }

    public static void main(String[] args) {
        solve(6);
    }
}
