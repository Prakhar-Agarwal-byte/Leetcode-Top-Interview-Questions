class Solution {
  public int findKthLargest(int[] nums, int k) {
    k = nums.length - k;
    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      int p = partition(low, high, nums);
      if (p < k) {
        low = p + 1;
      }
      if (p > k) {
        high = p - 1;
      }
      if (p == k) {
        break;
      }
    }
    return nums[k];
  }

  private int partition(int low, int high, int[] nums) {
    int i = low;
    int pivot = nums[high];
    for (int j = low; j < high; j++) {
      if (nums[j] <= pivot) {
        swap(i, j, nums);
        i++;
      }
    }
    swap(i, high, nums);
    return i;
  }

  private void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
