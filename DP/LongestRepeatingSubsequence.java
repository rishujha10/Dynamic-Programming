package DP;

import java.util.Arrays;
/*Given a string, find the length of the longest repeating subsequence, such that the two subsequences don’t have same string character at the same position, i.e. any ith character in the two subsequences shouldn’t have the same index in the original string.  */
public class LongestRepeatingSubsequence {
      static int dp[][] = new int[1001][1001];
    static {
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
    }
    static int lpr(String s){
        int n=s.length();
        int m=s.length();
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i - 1) == s.charAt(j - 1)&&i!=j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            
            }
        }
        return dp[n][m];
    }
   
    public static void main(String[] args) {
        String s="AABEBCDD";   //o/p: "ABD" i.e. length=3
        System.out.println(lpr(s));
    }
}
