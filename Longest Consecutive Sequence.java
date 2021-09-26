import java.util.HashSet;

class Solution {
  public int longestConsecutive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i] - 1))
        continue;
      int temp = nums[i];
      int count = 0;
      while (set.contains(temp++)) {
        count++;
      }
      max = Math.max(max, count);
    }
    return max;
  }
}
