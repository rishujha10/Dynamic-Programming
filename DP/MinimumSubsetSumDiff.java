package DP;

//We are given an array ‘ARR’ with N positive integers. We need to partition the array into two subsets such that the absolute difference of the sum of elements of the subsets is minimum.
//We need to return only the minimum absolute difference of the sum of elements of the two partitions.
import java.util.Arrays;

public class MinimumSubsetSumDiff {
    static int minSubsetSumDiff(int arr[],int n){
        int sum=Arrays.stream(arr).sum();
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[0][j] = false;
                }
                if (j == 0) {
                    dp[i][0] = true;
                }

            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=sum;i++){      //run a loop till the total sum(range) of the array to find first subset
            if(dp[n-1][i]){      //only check for the true values of the last row of dp matrix
                int diff=Math.abs((i-(sum-i)));    
                min=Math.min(min,diff);
            }
        }
        return min;
    }
   
    public static void main(String[] args) {
        int a[]={1,6,11,5};
        System.out.println(minSubsetSumDiff(a, a.length));
    }
}
