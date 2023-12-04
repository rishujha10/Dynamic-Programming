package DP;

import java.util.Arrays;

public class ShortestCommonSupersequence {
    static int dp[][] = new int[1001][1001];
    static {
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
    }

    // static int shortestCommmonSupersequence(String X, String Y, int n, int m) {
    // if (n == 0) {
    // return m;
    // }
    // if (m == 0) {
    // return n;
    // }
    // if (X.charAt(n - 1) == Y.charAt(m - 1)) {
    // return 1 + shortestCommmonSupersequence(X, Y, n - 1, m - 1);
    // } else {
    // return 1+ Math.min(shortestCommmonSupersequence(X, Y, n - 1, m),
    // shortestCommmonSupersequence(X, Y, n, m - 1));
    // }
    // }
    // An easy method is to subtract lcs from total length of combined strings
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
    static int shortestCommmonSupersequence(String X,String Y, int n,int m)
    {
        int l=lcs(X, Y, n, m);
        return (m+n)-l;
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println(shortestCommmonSupersequence(X, Y, X.length(), Y.length()));

    }
}
