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
  public int amountOfTime(TreeNode root, int start) {
    Map<Integer, TreeNode> parent = new HashMap<>();
    Queue<TreeNode> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    TreeNode startNode = dfs(root, parent, start);
    queue.offer(startNode);
    visited.add(startNode.val);
    int minutes = -1;
    
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left != null && visited.add(node.left.val)) {
          queue.offer(node.left);
        }
        if (node.right != null && visited.add(node.right.val)) {
          queue.offer(node.right);
        }
        if (parent.get(node.val) != null && visited.add(parent.get(node.val).val)) {
          queue.offer(parent.get(node.val));
        }
      }
      minutes++;
    }
    
    return minutes;
  }
  
  private TreeNode dfs(TreeNode node, Map<Integer, TreeNode> parent, int start) {
    if (node == null) {
      return null;
    }
    if (node.val == start) {
      return node;
    }
    if (node.left != null) {
      parent.put(node.left.val, node);
      TreeNode left = dfs(node.left, parent, start);
      if (left != null) {
        return left;
      }
    }
    if (node.right != null) {
      parent.put(node.right.val, node);
      TreeNode right = dfs(node.right, parent, start);
      if (right != null) {
        return right;
      }
    }
    return null;
  }
}