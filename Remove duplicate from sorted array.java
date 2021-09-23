class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0)
      return 0;
    int i = 0;
    int j = 1;
    int count = 1;
    for (; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        count++;
        nums[++i] = nums[j];
      }
    }
    return count;
  }
}
