package io.algoexpert.easy.validatesubsequence;

import java.util.*;

public class Main {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        Set<Integer> integerSet = new HashSet<>(array);

        int i = 0;
        while(i < sequence.size()){
            if(integerSet.contains(sequence.get(i)))
                i++;
            else
                break;
        }

        if(i >= sequence.size())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, 8, 10);
        boolean result = isValidSubsequence(array, sequence);

        System.out.println(result);
    }
}
