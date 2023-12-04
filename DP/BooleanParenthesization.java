package DP;

import java.util.HashMap;
import java.util.Map;

public class BooleanParenthesization {
    static Map<String, Integer> mp = new HashMap<>();

    // RECURSION
    // static int solve(String s, int i, int j, boolean isTrue) {
    // if (i > j)
    // return 0;
    // if (i == j) {
    // if (isTrue)
    // return s.charAt(i) == 't' ? 1 : 0;
    // else
    // return s.charAt(i) == 'f' ? 1 : 0;
    // }

    // int ans = 0;
    // for (int k = i + 1; k < j; k += 2) {
    // int lt = solve(s, i, k - 1, true);
    // int lf = solve(s, i, k - 1, false);
    // int rt = solve(s, k + 1, j, true);
    // int rf = solve(s, k + 1, j, false);

    // if (s.charAt(k) == '&') {
    // if (isTrue)
    // ans += lt * rt;
    // else
    // ans += lf * rf + lf * rt + lt * rf;
    // } else if (s.charAt(k) == '|') {
    // if (isTrue)
    // ans += (lt * rt) + (lt * rf) + (lf * rt);
    // else
    // ans += (lf * rf);
    // } else if (s.charAt(k) == '^') {
    // if (isTrue)
    // ans += lt * rf + rt * lf;
    // else
    // ans += lt * rt + lf * rf;
    // }
    // }
    // return ans;
    // }

    // MEMOIZATION
    static long solve(String s, int i, int j, boolean isTrue) {
        if (i > j)
            return 0;
        if (i == j) {
            if (isTrue)
                return s.charAt(i) == 't' ? 1 : 0;
            else
                return s.charAt(i) == 'f' ? 1 : 0;
        }

        String temp = i + " " + j + " " + isTrue;
        if (mp.containsKey(temp)) {
            return mp.get(temp);
        }

        long ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            int lt = (int)solve(s, i, k - 1, true);
            int lf = (int)solve(s, i, k - 1, false);
            int rt = (int)solve(s, k + 1, j, true);
            int rf = (int)solve(s, k + 1, j, false);

            if (s.charAt(k) == '&') {
                if (isTrue)
                    ans += lt * rt;
                else
                    ans += lf * rf + lf * rt + lt * rf;
            } else if (s.charAt(k) == '|') {
                if (isTrue)
                    ans += (lt * rt) + (lt * rf) + (lf * rt);
                else
                    ans += (lf * rf);
            } else if (s.charAt(k) == '^') {
                if (isTrue)
                    ans += lt * rf + rt * lf;
                else
                    ans += lt * rt + lf * rf;

            }
            mp.put(temp, (int)(ans%1003));
        }
        return mp.get(temp);
    }

    public static void main(String[] args) {
        // String s = "t^f&t";
        String s="t^f|f";
        // String s = "t|t&f^t";
        int i = 0;
        int j = s.length() - 1;
        System.out.println(solve(s, i, j, true));
    }
}
