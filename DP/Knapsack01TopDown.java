package DP;

import java.util.Arrays;

//0/1 Knapsack using top down approach(real DP)/tabulation
//Replace n,W from memoization approach to i,j
//recursion changes to iteration
//base contd changes to initialization of DP matrix
public class Knapsack01TopDown {

    static int knapsack(int wt[], int val[], int W, int n) {
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int wt[]={4,5,1};
        int val[]={1,2,3};
        System.out.println(knapsack(wt, val, 4, 3));
    }
}
