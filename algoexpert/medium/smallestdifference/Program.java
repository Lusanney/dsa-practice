package io.algoexpert.medium.smallestdifference;

import java.util.Arrays;

public class Program {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int arrayOneIdx = 0;
        int arrayTwoIdx = 0;

        int smallestDiff = Integer.MAX_VALUE;
        int [] smallestPair = new int[2];

        while(arrayOneIdx < arrayOne.length && arrayTwoIdx < arrayTwo.length){
            int firstNum = arrayOne[arrayOneIdx];
            int secondNum = arrayTwo[arrayTwoIdx];

            int current = Math.abs(firstNum - secondNum);

            if(firstNum < secondNum){
                arrayOneIdx++;
            }else if(firstNum > secondNum){
                arrayTwoIdx++;
            }else if(firstNum == secondNum)
                return new int[]{firstNum, secondNum};

            if(smallestDiff > current){
                smallestDiff = current;
                smallestPair[0] = firstNum;
                smallestPair[1] = secondNum;
            }
        }

        return smallestPair;
    }
}
