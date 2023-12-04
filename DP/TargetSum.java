package DP;


import java.io.*;
import java.util.*;

class TargetSum{
        static int mod = (int) (Math.pow(10, 9) + 7);
static int findWays(int[] num, int tar) {
        int n = num.length;

        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n][tar + 1];

        // Initialize the dp array for the first element of the array
        if (num[0] == 0)
            dp[0][0] = 2; // 2 cases - pick and not pick
        else
            dp[0][0] = 1; // 1 case - not pick

        if (num[0] != 0 && num[0] <= tar)
            dp[0][num[0]] = 1; // 1 case - pick

        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= tar; target++) {
                int notTaken = dp[ind - 1][target];

                int taken = 0;
                if (num[ind] <= target)
                    taken = dp[ind - 1][target - num[ind]];

                dp[ind][target] = (notTaken + taken) % mod;
            }
        }

        return dp[n - 1][tar];
    }
    static int findTargetSumWays(int[] A , int N, int target) {
        // code here
        int totSum = 0;

        // Calculate the total sum of elements in the array
        for (int i = 0; i < N; i++) {
            totSum += A[i];
        }

        // Checking for edge cases
        if (totSum - target < 0 || (totSum - target) % 2 == 1)
            return 0;

        return findWays(A, (totSum - target) / 2);
    }
    public static void main(String[] args) {
        int a[]={1,1,1,1,1};
        int target=3;
        System.out.println(findTargetSumWays(a, a.length, target));
    }
}