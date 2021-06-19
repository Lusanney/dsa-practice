package io.algoexpert.easy.findthreelargestnum;

public class Main {
    public static int[] findThreeLargestNumbers(int[] array) {
        int larg1 = Integer.MIN_VALUE;
        int larg2 = Integer.MIN_VALUE;
        int larg3 = Integer.MIN_VALUE;
        for(int el: array){
            if(el > larg1){
                larg3 = larg2;
                larg2 = larg1;
                larg1 = el;
                continue;
            }
            if (el > larg2){
                larg3 = larg2;
                larg2 = el;
                continue;
            }
            if (el > larg3)
                larg3 = el;
        }

        return new int[]{larg3, larg2, larg1};
    }
}
