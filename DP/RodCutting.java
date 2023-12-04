package DP;
/* Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

*/
public class RodCutting {
    public static int cutRod(int price[], int n) {
        // code here
        int arr[] = new int[n];      //this array is used to store each piece size of rod
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][n];   //here both dimension are based on size of rod
    }

    public static void main(String[] args) {
        int n=8;
        int price[]={1,5,8,9,10,17,17,20};
        System.out.println(cutRod(price, n));  //Explanation:The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and  6, i.e., 5+17=22.

    }
}