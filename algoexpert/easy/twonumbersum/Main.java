package io.algoexpert.easy.twonumbersum;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer, Boolean> reverseMap = new HashMap<Integer, Boolean>();

        // Turn into hashmap
        for(int i=0; i < array.length; i++)
            reverseMap.put(targetSum - array[i], true);

        // find it
        for(int i=0; i < array.length; i++)
            if(reverseMap.containsKey(array[i]) && array[i] != targetSum - array[i])
                return new int[]{array[i], targetSum - array[i]};
        return new int[0];
    }

    public static void main(String[] args) {
        int [] array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
        int [] result = twoNumberSum(array, targetSum);

        System.out.println(result.toString());
    }
}
