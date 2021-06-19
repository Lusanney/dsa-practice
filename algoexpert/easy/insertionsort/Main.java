package io.algoexpert.easy.insertionsort;

public class Main {
    private static void swap(int[] array, int idxX, int idxY){
        int temp = array[idxX];
        array[idxX] = array[idxY];
        array[idxY] = temp;
    }

    public static int[] insertionSort(int[] array) {
        if(array.length == 0)
            return new int[] {};

        if(array.length == 1)
            return array;

        for(int i=1; i<array.length; i++){
            int currentIdx = i;
            int backCheckIdx = currentIdx-1;
            while(backCheckIdx >= 0 && array[backCheckIdx] > array[currentIdx]){
                swap(array, currentIdx, backCheckIdx);
                currentIdx = backCheckIdx;
                backCheckIdx--;
            }
        }

        return array;
    }
}
