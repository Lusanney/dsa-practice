package io.algoexpert.easy.binarysearch;

public class Main {
    public static int binarySearch(int[] array, int target) {
        if(array.length <= 1)
            return array.length - 1;

        int startIdx = 0;
        int endIdx = array.length - 1;

        while(startIdx <= endIdx){
            int midIdx = Math.floorDiv((endIdx + startIdx), 2);

            if(array[midIdx] == target)
                return midIdx;

            if(array[midIdx] > target)
                endIdx = midIdx - 1;
            else
                startIdx = midIdx + 1;
        }
        return -1;
    }
}
