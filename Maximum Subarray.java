class Solution {
  public int maxSubArray(int[] nums) {
    int curSum = 0;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      curSum += nums[i];
      max = Math.max(max, curSum);
      if (curSum < 0) {
        curSum = 0;
      }
    }
    return max;
  }
}
