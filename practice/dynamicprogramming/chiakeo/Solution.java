package practice.dynamicprogramming.chiakeo;

/**
 * Having N packs of candies, each has A[i] candies.
 * Split those packs into 2, so that the difference between
 * each pack is smallest.
 */
public class Solution {
    private static void solve(int [] packs){
        int totalSum = 0;
        for(int pack:packs){
            totalSum+= pack;
        }

        // We want to find the maximum sum that is smaller than totalSum / 2
        int targetSmallerSum = totalSum / 2;

        // using
    }
    public static void main(String[] args) {

    }
}
