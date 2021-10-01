class Solution {
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    rotArr(nums, 0, nums.length - 1);
    rotArr(nums, 0, k - 1);
    rotArr(nums, k, nums.length - 1);
  }

  private void rotArr(int[] nums, int i, int j) {
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
