class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == null || q == null)
      return null;
    if (root == p)
      return p;
    if (root == q)
      return q;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null)
      return root;
    if (left == null)
      return right;
    return left;
  }
}
