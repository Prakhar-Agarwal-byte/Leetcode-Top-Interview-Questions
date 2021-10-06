class Solution {
  public boolean increasingTriplet(int[] nums) {
    int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE;
    for (int k = 0; k < nums.length; k++) {
      if (nums[k] <= i) {
        i = nums[k];
      } else if (nums[k] <= j) {
        j = nums[k];
      } else {
        return true;
      }
    }
    return false;
  }
}
