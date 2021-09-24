import java.util.*;

class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(nums, new ArrayList<Integer>(), list);
    return list;
  }

  private void backtrack(int[] nums, ArrayList<Integer> temp, List<List<Integer>> list) {
    if (temp.size() == nums.length) {
      list.add(new ArrayList<>(temp));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (temp.contains(nums[i]))
        continue;
      temp.add(nums[i]);
      backtrack(nums, temp, list);
      temp.remove(temp.size() - 1);
    }
  }
}
