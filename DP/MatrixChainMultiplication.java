package DP;

import java.util.Arrays;

/*Given the dimension of a sequence of matrices in an array arr[], where the dimension of the ith matrix is (arr[i-1] * arr[i]), the task is to find the most efficient way to multiply these matrices together such that the total number of element multiplications is minimum. */
public class MatrixChainMultiplication {
    static int dp[][]=new int[1001][1001];
    static{
        for(int i[]:dp){
            Arrays.fill(i, -1);
        }
    }

    //Memoization
    static int solveMcm(int arr[], int i, int j) {

        if (i >= j) {
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp=solveMcm(arr, i, k)+solveMcm(arr, k+1, j)+(arr[i-1]*arr[k]*arr[j]);
            if(temp<min)
            {
                min=temp;
            }
        }
        return dp[i][j]=min;
    }
    //RECURSION

    // static int solveMcm(int arr[], int i, int j) {
    //     if (i >= j) {
    //         return 0;
    //     }
    //     int min=Integer.MAX_VALUE;
    //     for(int k=i;k<=j-1;k++){
    //         int temp=solveMcm(arr, i, k)+solveMcm(arr, k+1, j)+(arr[i-1]*arr[k]*arr[j]);
    //         if(temp<min)
    //         {
    //             min=temp;
    //         }
    //     }
    //     return min;
    // }

    public static void main(String[] args) {
        int arr[]={40,20,30,10,30};
        // int arr[]={1,2,3,4,3};
        System.out.println(solveMcm(arr, 1, arr.length-1));
    }
}
