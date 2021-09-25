import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list;

    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<Integer>();
        return valid(root);
    }

    private boolean valid(TreeNode root) {
        inorder(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i))
                return false;
        }
        return true;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

}
