package io.algoexpert.medium.maxsubsetsumnoadjacent;

import java.util.*;

class Program {
    public static int max = Integer.MIN_VALUE;

    private static void maxSubsetSumNoAdjacent(int[] array, int startIdx, int currentSum){
        if(startIdx >= array.length && max < currentSum){
            max = currentSum;
            return;
        }

        for(int i=startIdx; i < array.length; i++){
            maxSubsetSumNoAdjacent(array, i+2, currentSum + array[i]);
        }
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        max = 0;
        maxSubsetSumNoAdjacent(array, 0, 0);
        return max;
    }

    public static void main(String[] args) {
        maxSubsetSumNoAdjacent(new int[]{75, 105, 120, 75, 90, 135});
    }
}

