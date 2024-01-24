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
  int res = 0;
  public int pseudoPalindromicPaths (TreeNode root) {
    dfs(root, 0);
    return res;
  }

  private void dfs(TreeNode root, int count) {
    if (root != null) {
      // compute occurences of each digit 
      // in the corresponding register
      count ^= 1 << root.val;
      // if it's a leaf, check if the path is pseudo-palindromic
      if (root.left == null && root.right == null) {
        // check if at most one digit has an odd count
        if ((count & (count - 1)) == 0) {
          ++res;
        }
      }
      dfs(root.left, count);
      dfs(root.right, count);
    }
  }
}