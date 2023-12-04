package DP;

import java.util.Arrays;

public class EggDrop {
    static int dp[][]=new int[201][201];
    static{
        for(int i[]:dp)
        {
            Arrays.fill(i, -1);
        }
    }
//RECURSION
    // static int eggDrop(int e,int f){
        
    //     if(f==1||f==0){
    //         return f;
    //     }
    //     if(e==1){
    //         return f;
    //     }
    //     int min=Integer.MAX_VALUE;
    //     for(int k=1;k<=f;k++){
    //         int temp=1+Math.max(eggDrop(e-1,k-1),eggDrop(e,f-k));
    //         min=Math.min(min,temp);
    //     }
    //     return min;
    // }

//MEMOIZATION  LINEAR SEARCH GFG SOLTN
    // static int eggDrop(int e,int f){
        
    //     if(f==1||f==0){
    //         return f;
    //     }
    //     if(e==1){
    //         return f;
    //     }
    //     if(dp[e][f]!=-1){
    //         return dp[e][f];
    //     }
    //     int min=Integer.MAX_VALUE;
    //     for(int k=1;k<=f;k++){
    //         int temp=1+Math.max(eggDrop(e-1,k-1),eggDrop(e,f-k));
    //         min=Math.min(min,temp);
    //     }
    //     return dp[e][f]=min;
    // }

//MEMOIZATON BINARY SEARCH LEETCODE SOLTN.
     static int eggDrop(int e,int f){
        
        if(f==1||f==0){
            return f;
        }
        if(e==1){
            return f;
        }
        if(dp[e][f]!=-1){
            return dp[e][f];
        }
        int l=1,h=f;
        int min=Integer.MAX_VALUE;
        while(l<=h){
            int mid=(l+h)/2;
            int left=eggDrop(e-1,mid-1);
            int right=eggDrop(e, f-mid);
            int temp=1+Math.max(left,right);

            if(left<right){
                l=mid+1;
            }else{
                h=mid-1;
            }
             min=Math.min(min,temp);
        }
        return dp[e][f]=min;
    }
    public static void main(String[] args) {
        System.out.println(eggDrop(2, 10));
    }
}
