package io.algoexpert.easy.palindromecheck;

public class Main {
    public static boolean isPalindrome(String str) {
        int startIdx = 0;
        int endIdx = str.length() - 1;

        while(startIdx < endIdx && str.charAt(startIdx) == str.charAt(endIdx)){
            startIdx++;
            endIdx--;
        }

        return startIdx >= endIdx;
    }
}
