package nofailcontest.nofailc;

import java.math.BigInteger;
import java.util.*;

public class Solution {
    private static long N;
    private static int K;
    private static BigInteger mod;

    private static void fibonacci(long nth){
        if(nth <= 2)
            System.out.println(1);

        BigInteger firstNum = new BigInteger("1");
        BigInteger secondNum = new BigInteger("1");

        long idx = 2;

        while (idx <nth){

            BigInteger temp = new BigInteger(secondNum.toString());

            secondNum = secondNum.add(firstNum).mod(mod);
            firstNum = new BigInteger(temp.toString());
            idx++;
        }


        String result = secondNum.toString();

        if(result.length() > K)
            System.out.println(result.substring(result.length() - K));
        else
            System.out.println(result);
    }

    private static void solve(){
        fibonacci(N);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String [] inputs = scanner.nextLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);


        mod = new BigInteger("10");
        mod = mod.pow(K + 1);
        solve();

    }
}
