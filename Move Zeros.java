class Solution {
  public void moveZeroes(int[] nums) {
    int i = 0;
    int j = 0;
    int n = nums.length;
    while (j < n) {
      if (nums[i] != 0) {
        i++;
      } else if (nums[j] != 0) {
        swap(i, j, nums);
      } else {
        j++;
      }
    }
  }

  private void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
