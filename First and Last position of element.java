class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    res[0] = firstElement(nums, target);
    res[1] = lastElement(nums, target);
    return res;
  }

  private int firstElement(int[] nums, int target) {
    int index = -1;
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (target == nums[mid])
        index = mid;
      if (target > nums[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return index;
  }

  private int lastElement(int[] nums, int target) {
    int index = -1;
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (target == nums[mid])
        index = mid;
      if (target >= nums[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return index;
  }
}
