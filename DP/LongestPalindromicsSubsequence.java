package DP;

import java.util.Arrays;

public class LongestPalindromicsSubsequence {
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
    public static int longestPalinSubseq(String S)
    {
        //code here
        StringBuilder sb=new StringBuilder(S);
        String r=sb.reverse().toString();
        int n=S.length();
        return lcs(S,r,n,n);
        
    }
    public static void main(String[] args) {
        String s="agbcba";
        System.out.println(longestPalinSubseq(s));
    }
}
