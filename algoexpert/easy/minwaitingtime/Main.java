package io.algoexpert.easy.minwaitingtime;

import java.util.Arrays;

public class Main {
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);

        int sum = 0;
        for(int i=0; i< queries.length; i++){
            sum+= i*queries[(queries.length - 1) - i];
        }
        return sum;
    }
}
