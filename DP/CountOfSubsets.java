package DP;

//given an array with a sum ,find the no. of subsets that can be formed whose sum is equal to the input sum
//sames as subset problem except OR changes to +
public class CountOfSubsets{

    static int countofSubsets(int arr[],int n,int sum){
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
        int a[]={2,3,5,6,8,10};
        int sum=10;
        System.out.println(countofSubsets(a, a.length, sum));
    }
}