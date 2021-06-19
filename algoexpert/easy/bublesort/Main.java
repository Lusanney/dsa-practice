package io.algoexpert.easy.bublesort;

public class Main {
    public static int[] bubbleSort(int[] array) {
        for(int i=0; i< array.length -1; i++)
            for(int j=i+1; j < array.length; j++){
                if(array[j] < array[i]){
                    int m = array[i];
                    array[i] = array[j];
                    array[j] = m;
                }
            }
        return array;
    }
}
