package io.algoexpert.medium.moveelementtoend;

import java.util.*;

public class Program {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int startIdx = 0;
        int endIdx = array.size() - 1;

        while(startIdx < endIdx){
            // Find the toMove at the start of the arrray
            while(array.get(startIdx) != toMove && startIdx < endIdx) startIdx++;
            while(array.get(endIdx) == toMove && startIdx < endIdx) endIdx--;

            if(startIdx < endIdx){
                //Swap
                int temp = array.get(startIdx);
                array.set(startIdx, array.get(endIdx));
                array.set(endIdx, temp);
            }
        }

        return array;
    }
}
