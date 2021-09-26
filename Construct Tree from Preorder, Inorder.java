class Solution {
  int index = 0;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return util(preorder, inorder, 0, inorder.length - 1);
  }

  private TreeNode util(int[] preorder, int[] inorder, int start, int end) {
    if (start > end)
      return null;
    TreeNode node = new TreeNode(preorder[index++]);
    int indexInorder = search(inorder, start, end, node.val);
    node.left = util(preorder, inorder, start, indexInorder - 1);
    node.right = util(preorder, inorder, indexInorder + 1, end);
    return node;
  }

  private int search(int[] inorder, int start, int end, int val) {
    int i = start;
    for (; i <= end; i++) {
      if (inorder[i] == val) {
        return i;
      }
    }
    return -1;
  }
}
