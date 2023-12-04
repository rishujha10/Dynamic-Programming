
package DP;
import java.util.Arrays;
//(memoization) bottom upnapproach of 0/1 knapsack problem
public class Knapsack01DP {
    static int dp[][]=new int[102][1002];
    static{
    for(int []i:dp){
      Arrays.fill(i,-1);
    }
}
    static int knapsack(int wt[],int val[],int W,int n){
        if(n==0||W==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){
            return dp[n][W]= Math.max(val[n-1]+knapsack(wt, val, W-wt[n-1], n-1),knapsack(wt, val, W, n-1));
        }
        else
            return dp[n][W]= knapsack(wt, val, W, n-1);
        }
    public static void main(String[] args) {
        int wt[]={4,5,1};
        int val[]={1,2,3};
        System.out.println(knapsack(wt, val, 4, 3));
    }
}
