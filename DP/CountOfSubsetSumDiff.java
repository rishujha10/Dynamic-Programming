package DP;

/* Given an array arr[] of size N and a given difference diff, the task is to count the number of partitions that we can perform such that the difference between the sum of the two subsets is equal to the given difference. */
import java.util.Arrays;

public class CountOfSubsetSumDiff {
    static int countofSubsetSumDiff(int arr[], int n, int diff) {
        int sumOfArray = Arrays.stream(arr).sum();
        int sum = (diff + sumOfArray) / 2;
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
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 1, 2 };
        int diff = 1;
        System.out.println(countofSubsetSumDiff(a, a.length, diff));
    }
}
