// Leetcode 1641
class Solution {
    public int countVowelStrings(int n) {
        int [] vowels = new int[]{1, 1, 1, 1, 1};

        for(int i = 1 ; i < n; i++)
            for(int j = 1; j < 5; j ++)
                vowels[j] += vowels[j-1];
            
        int result = 0;
        for(int i = 0; i < 5; i++) 
            result += vowels[i];

        return result;
    }
}