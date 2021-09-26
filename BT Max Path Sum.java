class Solution {
  int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    util(root);
    return maxSum;
  }

  private int util(TreeNode root) {
    if (root == null)
      return 0;
    int left = util(root.left);
    int right = util(root.right);
    int sum = Math.max(Math.max(root.val, left + root.val), Math.max(right + root.val, left + right + root.val));
    maxSum = Math.max(maxSum, sum);
    int singlePathSum = Math.max(Math.max(root.val, left + root.val), right + root.val);
    return singlePathSum;
  }
}
