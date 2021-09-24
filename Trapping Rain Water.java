class Solution {
  public int trap(int[] height) {
    int maxLeft = height[0];
    int maxRight = height[height.length - 1];
    int left = 1;
    int right = height.length - 2;
    int res = 0;
    while (left <= right) {
      if (maxLeft <= maxRight) {
        if (height[left] > maxLeft) {
          maxLeft = height[left];
        } else {
          res += maxLeft - height[left];
          left++;
        }
      } else {
        if (height[right] > maxRight) {
          maxRight = height[right];
        } else {
          res += maxRight - height[right];
          right--;
        }
      }
    }
    return res;
  }
}
