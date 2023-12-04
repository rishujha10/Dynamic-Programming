package DP;
// 0/1 Knapsack problem Recursive approach
public class Knapsack01 {
    static int knapsack(int wt[],int val[],int W,int n){
        if(n==0||W==0){
            return 0;
        }
        if(wt[n-1]<=W){
            return Math.max(val[n-1]+knapsack(wt, val, W-wt[n-1], n-1),knapsack(wt, val, W, n-1));
        }
        else
            return knapsack(wt, val, W, n-1);
        }
    public static void main(String[] args) {
        int wt[]={4,5,6};
        int val[]={1,2,3};
        System.out.println(knapsack(wt, val, 3, 3));
    }
}
