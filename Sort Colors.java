class Solution {
  public void sortColors(int[] nums) {
    int low = 0;
    int mid = 0;
    int high = nums.length - 1;
    while (mid <= high) {
      switch (nums[mid]) {
        case 0:
          swap(low++, mid++, nums);
          break;
        case 1:
          mid++;
          break;
        case 2:
          swap(high--, mid, nums);
          break;
      }
    }
  }

  private void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
