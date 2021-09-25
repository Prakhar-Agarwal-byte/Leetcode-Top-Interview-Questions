import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(0, new ArrayList<Integer>(), list, nums);
    return list;
  }

  private void backtrack(int index, ArrayList<Integer> temp, List<List<Integer>> list, int[] nums) {
    list.add(new ArrayList<>(temp));
    for (int i = index; i < nums.length; i++) {
      temp.add(nums[i]);
      backtrack(i + 1, temp, list, nums);
      temp.remove(temp.size() - 1);
    }
  }

}
