class Solution {
  public int maxProduct(int[] nums) {
    int minVal = nums[0];
    int maxVal = nums[0];
    int maxProd = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < 0) {
        int temp = minVal;
        minVal = maxVal;
        maxVal = temp;
      }
      minVal = Math.min(nums[i], minVal * nums[i]);
      maxVal = Math.max(nums[i], maxVal * nums[i]);
      maxProd = Math.max(maxProd, maxVal);
    }
    return maxProd;
  }
}
