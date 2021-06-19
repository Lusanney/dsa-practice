package io.algoexpert.easy.selectionsort;

public class Main {

    public static int[] selectionSort(int[] array) {
        for(int i=0; i < array.length -1; i++){
            int minIdx = i;
            for(int j=i; j < array.length; j++){
                if(array[j] < array[minIdx])
                    minIdx = j;
            }

            // swap
            int temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }

        return array;
    }
}
