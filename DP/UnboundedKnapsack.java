package DP;
//Unbounded Knapsack, here repetitions of items are allowed
public class UnboundedKnapsack {
    static int unboundedknapsack(int wt[], int val[], int W, int n) {
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int W=8;
        // int W=100;
        int val[]={10,40,50,70};
        // int val[]={1,30};
        int wt[]={1,3,4,5};
        // int wt[]={1,50};
        System.out.println(unboundedknapsack(wt, val, W, val.length));

    }
}
