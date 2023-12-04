package DP;
//Tabulation approach 
public class LongestCommonSubstring {
    static int lcs(String X, String Y, int n,int m){
        int dp[][]=new int[n+1][m+1];
        int res=0;
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else if(X.charAt(i-1)==Y.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    res=Math.max(res,dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return res;
    }
 public static void main(String[] args) {
    String X="abcde";
    String Y="abfce";         //o/p=2 , since longest common substring is "ab"
    System.out.println(lcs(X, Y, X.length(),Y.length()));
 }  
}
