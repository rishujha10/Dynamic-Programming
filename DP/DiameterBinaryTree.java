package DP;


 public class DiameterBinaryTree {
      int val;
      DiameterBinaryTree left;
      DiameterBinaryTree right;
      DiameterBinaryTree() {}
      DiameterBinaryTree(int val) { this.val = val; }
    DiameterBinaryTree(int val, DiameterBinaryTree left, DiameterBinaryTree right) {
       this.val = val;
 this.left = left;
     this.right = right;
   }
  }

class Solution {
      int diameter = Integer.MIN_VALUE; 
      private int solve(DiameterBinaryTree node){
         if (node == null)
            return 0;

        //Main logic
        int left = solve(node.left);
        int right = solve(node.right);
        int temp=1+Math.max(left,right);
        int diameterAtCurrentNode= 1+left + right;   //incase of leetcode : only left+right
        diameter = Math.max(diameter, diameterAtCurrentNode);
        return temp;     //return temporary answer

    }
    public int diameterOfBinaryTree(DiameterBinaryTree node) {
        // Your code here
      solve(node);
      return diameter;    //return ans

    }
    public static void main(String[] args) {
          DiameterBinaryTree root = new DiameterBinaryTree(1);
        root.left = new DiameterBinaryTree(2);
        root.right = new DiameterBinaryTree(3);
        root.left.left = new DiameterBinaryTree(4);
        root.left.right = new DiameterBinaryTree(5);

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Calculate and print the diameter of the binary tree
        System.out.println("Diameter of the binary tree: " + solution.diameterOfBinaryTree(root));
    }
   
}