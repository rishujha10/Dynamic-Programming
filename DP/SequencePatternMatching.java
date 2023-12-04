package DP;

import java.util.Arrays;
/*Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not). */
public class SequencePatternMatching {
    static int dp[][] = new int[1001][1001];
    static {
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
    }

    static int lcs(String X, String Y, int n, int m) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
    static boolean isSubsequence(String a, String b){
        if(lcs(a, b, a.length(), b.length())==a.length()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String a="AXY";
        String b="ADXCPY";
        System.out.println(isSubsequence(a, b));   // here o/p is True.
    }
}
