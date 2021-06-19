package io.algoexpert.medium.monotonicarray;

public class Program {
    private static final int NEUTRAL = 0;

    public static boolean isMonotonic(int[] array) {
        int trend = NEUTRAL;

        if(array.length <= 2)
            return true;

        for(int i=0; i < array.length - 1; i ++){
            int diff = array[i+1] - array[i];
            if(diff == 0) continue;
            int currentTrend = Math.abs(diff) / diff;

            if(currentTrend == NEUTRAL)
                continue;
            else if(trend == NEUTRAL)
                trend = currentTrend;
            else if(currentTrend != trend)
                return false;
        }

        return true;
    }
}
