package DP;
//Maxmim Path Sum from any node to any node Leetcode And GFG Solution
// Definition for a binary tree node.
public class Node {
    int val;
    Node left;
    Node right;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution1 {
    int res = Integer.MIN_VALUE;

    int solve(Node node) {
        if (node == null) {
            return 0;
        }

        // Main logic
        int left = Math.max(0, solve(node.left));
        int right = Math.max(0, solve(node.right));
        int temp = Math.max(left, right) + node.val;
        int ans = left + right + node.val;
        res = Math.max(res, ans);
        return temp; //
        // return temporary answer

    }

    int maxPathSum(Node root) {
        if (root == null) {
            return 0;
        }
        solve(root);
        return res;
    }
    public static void main(String[] args) {
        // Example usage:
        // Constructing a binary tree:
        //        10
        //       / \
        //      2   10
        //     / \     \
        //    20  1    -25
        //               / \
        //              3   4

        Node root = new Node(10);
        root.left = new Node(2, new Node(20), new Node(1));
        root.right = new Node(10, null, new Node(-25, new Node(3), new Node(4)));

        Solution1 solution = new Solution1();
        int maxPathSum = solution.maxPathSum(root);

        System.out.println("Maximum Path Sum: " + maxPathSum);

}
}