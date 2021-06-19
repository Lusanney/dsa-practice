package practice.dynamicprogramming.ABProblem;

/**
 * Find the number of the String contains only A and B. Where B is allowed multiple times to be written,
 * If you want to print A, it needs to wrap K character of B inside.
 *
 * For example, N=4, K=2  (4 is the length of the String, 2 is the number of B inside wrapper A)
 *
 * -> BBBB
 * -> ABBB
 * -> BABB
 * -> BBAB
 * -> BBBA
 * -> ABBA
 *
 * -> 6 is the result.
 */
public class Solution {
    private static void solve(int N, int K){
        int[] result = new int[N];
        result[0] = 2;

        for(int i=1; i< N; i++)
            // Result[i-1] means, add B to existing array
            // Result[i-1-K] means, to add A
            if (i-1-K < 0)
                result[i] = result[i-1] + 1;
            else
                result[i] = result[i-1] + result[i-1-K];

        System.out.println(result[N - 1]);
    }

    public static void main(String[] args) {
        solve(5, 2);
    }
}
