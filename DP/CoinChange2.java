package DP;
/*You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin. */
public class CoinChange2 {
        public static int coinChange(int[] coins, int amount) {
            int n=coins.length;
            int dp[][]=new int[n+1][amount+1];
            dp[0][0]=0;
            for(int i=1;i<n+1;i++){
                dp[i][0]=0;
                }
                for(int i=1;i<amount+1;i++){
                    dp[0][i]=Integer.MAX_VALUE-1;
                }
                for(int i=1;i<n+1;i++){
                    for(int j=1;j<amount+1;j++){
                        if(coins[i-1]<=j){
                            dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                        }else{
                            dp[i][j]=dp[i-1][j];
                        }
                    }
                }
                
           if(dp[n][amount]==Integer.MAX_VALUE-1){
               return -1;
           }else{
            return dp[n][amount];
            }
        }
        public static void main(String[] args) {
            int a[]={1,2,3};
            int sum=5;
            System.out.println(coinChange(a, sum));
        }
    }
    
