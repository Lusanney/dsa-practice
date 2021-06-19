package practice.dynamicprogramming.daycontang;

/**
 * Given the array of integers, find the longest increasing sub-array.
 * Elements need not to be adjacent
 */
public class Solution {

    private static void solve(int array[]){
        // Init
        int[] longestArray = new int[array.length];

        //Base case
        longestArray[0] = 1;

        for(int i=1; i < array.length; i++){
            for(int checkPointer=i-1; checkPointer >= 0; checkPointer--){
                if(array[i] > array[checkPointer]){
                    longestArray[i] = Math.max(1, longestArray[checkPointer] + 1);
                    break;
                }
            }
        }

        System.out.println(longestArray[array.length - 1]);
    }

    public static void main(String[] args) {
        solve(new int[]{1, 5, 2, 4, 6, 10, 7, 11});
    }
}
