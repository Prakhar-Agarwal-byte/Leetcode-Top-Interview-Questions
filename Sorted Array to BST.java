class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0)
      return null;
    return util(nums, 0, nums.length - 1);
  }

  private TreeNode util(int[] nums, int low, int high) {
    if (low > high)
      return null;
    int mid = low + (high - low) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = util(nums, low, mid - 1);
    node.right = util(nums, mid + 1, high);
    return node;
  }
}
