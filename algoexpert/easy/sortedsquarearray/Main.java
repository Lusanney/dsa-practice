package io.algoexpert.easy.sortedsquarearray;

public class Main {
    public static int[] sortedSquaredArray(int[] array) {
        int pointerSt = 0;
        int pointerEn = array.length - 1;

        int[] result = new int[array.length];
        int position = array.length - 1;

        while (pointerSt <= pointerEn){
            int squareSt = (int) Math.pow(array[pointerSt], 2);
            int squareEn = (int) Math.pow(array[pointerEn], 2);

            if(squareSt >= squareEn && position >= 0){
                result[position] = squareSt;
                pointerSt++;
                position--;
            }else {
                result[position] = squareEn;
                pointerEn--;
                position--;
            }
        }
        return result;
    }
}
