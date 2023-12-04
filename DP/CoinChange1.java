package DP;
/*Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].  
Note: Assume that you have an infinite supply of each type of coin. And you can use any coin as many times as you want.

 */
public class CoinChange1 {
    static int maxWays(int coins[],int n,int sum)
    {
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[0][j] = 0;
                }
                if (j == 0) {
                    dp[i][0] = 1;
                }

            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int sum=10;
        int a[]={2,3,5,6};
        System.out.println(maxWays(a, a.length, sum));
    }
}
