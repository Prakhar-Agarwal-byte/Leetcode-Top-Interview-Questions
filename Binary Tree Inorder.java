import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
  Stack<TreeNode> st = new Stack<>();

  public List<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<>();
    pushAll(root);
    while (!st.isEmpty()) {
      TreeNode temp = st.pop();
      list.add(temp.val);
      pushAll(temp.right);
    }
    return list;
  }

  private void pushAll(TreeNode root) {
    while (root != null) {
      st.push(root);
      root = root.left;
    }
  }
}
