package DP;

import java.util.Arrays;

public class LongestCommonSubsequence {
    static int dp[][] = new int[1001][1001];
    static {
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
    }

    // RECURSION
    // static int lcs(String X, String Y, int n,int m)
    // {
    // if(n==0||m==0){
    // return 0;
    // }
    // if(X.charAt(n-1)==Y.charAt(m-1)){
    // return 1+lcs(X, Y, n-1, m-1);
    // }else{
    // return Math.max(lcs(X,Y,n-1,m),lcs(X,Y,n,m-1));
    // }
    // }
    // MEMOIZATION
    // static int lcs(String X, String Y, int n,int m)
    // {
    // if(n==0||m==0){
    // return 0;
    // }
    // if(dp[n][m]!=-1){
    // return dp[n][m];
    // }
    // if(X.charAt(n-1)==Y.charAt(m-1)){
    // return dp[n][m]=1+lcs(X, Y, n-1, m-1);
    // }else{
    // return dp[n][m]= Math.max(lcs(X,Y,n-1,m),lcs(X,Y,n,m-1));
    // }
    // }
    // TOP-DOWN DP
    // static int lcs(String X, String Y, int n,int m){
    // for(int i=0;i<n+1;i++){
    // for(int j=0;j<m+1;j++){
    // if(i==0||j==0){
    // dp[i][j]=0;
    // }
    // else if(X.charAt(i-1)==Y.charAt(j-1)){
    // dp[i][j]=1+ dp[i-1][j-1];
    // }else{
    // dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
    // }
    // }
    // }
    // return dp[n][m];
    // }

    //Printing LCS
    static String lcs(String X, String Y, int n, int m) {
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
                j--;
            } else {
                i--;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        // String X="AGGTAB";
        //  String Y="GXTXAYB";
          String X="aebcbda";
        StringBuilder sb=new StringBuilder(X);

     
       String Y=sb.reverse().toString();
        System.out.println(lcs(X, Y, X.length(), Y.length())); // for given string lcs="abdh" length=4
    }
}
