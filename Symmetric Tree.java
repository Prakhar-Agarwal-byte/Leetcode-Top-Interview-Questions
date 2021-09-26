class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;
    return util(root.left, root.right);
  }

  private boolean util(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null)
      return true;
    if (node1 == null || node2 == null)
      return false;
    return node1.val == node2.val && util(node1.left, node2.right) && util(node1.right, node2.left);
  }
}
