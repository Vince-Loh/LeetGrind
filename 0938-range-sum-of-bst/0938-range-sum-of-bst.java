/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) {
      return 0;
    }
    if (root.val < low) {
      // If the node's value is less than low, then we look into the right subtree
      return rangeSumBST(root.right, low, high);
    }
    if (root.val > high) {
      // If the node's value is greater than high, then we look into the left subtree
      return rangeSumBST(root.left, low, high);
    }
    // If the node's value is between low and high, we add the value to our sum and 
    // continue to search in both left and right subtrees.
    return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
  }
}