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
  public int maxAncestorDiff(TreeNode root) {
    return dfs(root, root.val, root.val);
  }

  private int dfs(TreeNode node, int mn, int mx) {
    if (node == null) {
      return mx - mn;
    }
    mx = Math.max(mx, node.val);
    mn = Math.min(mn, node.val);
    return Math.max(dfs(node.left, mn, mx), dfs(node.right, mn, mx));
  }
}