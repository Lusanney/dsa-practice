package io.algoexpert.easy.nthfibonacci;

public class Main {
    public static int getNthFib(int n) {
        if(n== 1)
            return 0;
        else if (n == 2)
            return 1;
        else {
            int [] f = new int[n];
            f[0] = 0;
            f[1] = 1;
            for(int i=2; i < n; i++){
                f[i] = f[i-1] + f[i-2];
            }

            return f[n - 1];
        }

    }

    public static void main(String[] args) {
        System.out.println(getNthFib(6));
    }
}
