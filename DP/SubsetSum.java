package DP;
//subset sum problem

public class SubsetSum {
    static boolean subsetSum(int arr[], int n, int sum) {
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
        return dp[n][sum];

    }

    public static void main(String[] args) {
        int a[]={2,3,5,7,8,10};
        int sum=11;
        if(subsetSum(a, a.length, sum)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
