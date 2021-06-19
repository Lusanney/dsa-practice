package io.algoexpert.medium.threenumbersum;

import java.util.*;

class Program {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);

        List<Integer[]> result = new ArrayList<>();

        for(int i=0; i < array.length - 2; i++){
            int leftIdx = i + 1;
            int rightIdx = array.length - 1;

            while(leftIdx < rightIdx){
                int tempTarget = array[i] + array[leftIdx] + array[rightIdx];

                // If exact case
                if(tempTarget == targetSum){
                    result.add(new Integer[]{array[i], array[leftIdx], array[rightIdx]});
                    leftIdx++;
                    rightIdx--;
                }
                else if(tempTarget > targetSum)
                    rightIdx--;
                else if(tempTarget < targetSum)
                    leftIdx++;
            }
        }

        return result;
    }
}
