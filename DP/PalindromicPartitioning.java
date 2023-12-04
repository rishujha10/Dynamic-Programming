package DP;

import java.util.Arrays;

public class PalindromicPartitioning {
      static int dp[][]=new int[1001][1001];
    static{
        for(int i[]:dp){
            Arrays.fill(i, -1);
        }
    }

    //RECURSION
    // static int solve(String s,int i,int j)
    // {
    //     if(i>=j||isPalindrome(s,i,j)){
    //         return 0;
    //     }
    //     int min=Integer.MAX_VALUE;
    //     for(int k=i;k<j;k++){
    //         int temp=solve(s, i, k)+solve(s, k+1, j)+1;
    //         min=Math.min(min, temp);
    //     }
    //     return min;
    // }

    //MEMOIZATION
    static int solve(String s,int i,int j)
    {
        if(i>=j||isPalindrome(s,i,j)){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp=solve(s, i, k)+solve(s, k+1, j)+1;
            min=Math.min(min, temp);
        }
        return dp[i][j]=min;
    }
    static boolean isPalindrome(String s,int i,int j){
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s="ababbbabbababa";
        // String s="geek";
        int i=0,j=s.length()-1;
        System.out.println(solve(s, i, j));
    }
}
