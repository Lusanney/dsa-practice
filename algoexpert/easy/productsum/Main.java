package io.algoexpert.easy.productsum;

import java.util.List;

public class Main {
    public static int productSum(List<Object> array, int level){
        int sum = 0;
        for(Object element: array){
            if(element instanceof Integer)
                sum += level * (int) element;
            else
                sum += level * productSum((List<Object>) element, level + 1);
        }

        return sum;
    }

    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }
}
