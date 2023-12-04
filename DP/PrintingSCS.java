package DP;

import java.util.Arrays;

public class PrintingSCS {
     static int dp[][] = new int[1001][1001];
    static {
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
    }
    static String SCS(String X, String Y, int n, int m) {
        StringBuilder sb = new StringBuilder();
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
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                sb.append(X.charAt(i - 1));
                i--;
                j--;
            }

            else if (dp[i][j - 1] > dp[i - 1][j]) {
                sb.append(Y.charAt(j-1));
                j--;
            } else {
                  sb.append(X.charAt(i-1));
                i--;
            }
        }
        while (i>0) {
            sb.append(X.charAt(i-1));
            i--;
        }
         while (j>0) {
            sb.append(Y.charAt(j-1));
            j--;
        }

        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println(SCS(X, Y, X.length(), Y.length()));

    }
}
