package DP;

import java.util.Arrays;
/*Input : 
str1 = "heap", str2 = "pea" 
Output : 
Minimum Deletion = 2 and
Minimum Insertion = 1
Explanation:
p and h deleted from heap
Then, p is inserted at the beginning
One thing to note, though p was required yet
it was removed/deleted first from its position and
then it is inserted to some other position.
Thus, p contributes one to the deletion_count
and one to the insertion_count.
 */
public class MinInsertDelete {
    static int dp[][] = new int[1001][1001];
    static {
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
    }

    static int lcs(String X, String Y, int n, int m) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    static void minInsertDelete(String X, String Y, int n, int m) {
        int l=lcs(X, Y, n, m);
        int deletions=X.length()-l;
        int insertions=Y.length()-l;
        System.out.println("insertions: "+insertions+" "+"deletions: "+deletions);
    }

    public static void main(String[] args) {
        String X="heap";
        String Y="pea";     //lcs="ea", deletions = heap-ea=4-2=2, insertions=pea-ea=3-2=1
        minInsertDelete(X, Y, X.length(), Y.length());

    }
}
