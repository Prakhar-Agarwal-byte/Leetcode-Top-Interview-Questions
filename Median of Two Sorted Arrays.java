class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }
    int x = nums1.length;
    int y = nums2.length;
    int start = 0;
    int end = x;
    
    while (start <= end) {
      int cutX = start + (end - start) / 2;
      int cutY = (x + y + 1) / 2 - cutX;
      int minLeftX = cutX == 0 ? Integer.MIN_VALUE : nums1[cutX - 1];
      int minLeftY = cutY == 0 ? Integer.MIN_VALUE : nums2[cutY - 1];
      int maxRightX = cutX == x ? Integer.MAX_VALUE : nums1[cutX];
      int maxRightY = cutY == y ? Integer.MAX_VALUE : nums2[cutY];

      if (minLeftX <= maxRightY && minLeftY <= maxRightX) {
        if ((x + y) % 2 == 0) {
          return (Math.max(minLeftX, minLeftY) + Math.min(maxRightX, maxRightY)) / (double) 2;
        } else {
          return Math.max(minLeftX, minLeftY);
        }
      }

      if (minLeftX < maxRightY) {
        start = cutX + 1;
      } else {
        end = cutX - 1;
      }
    }

    return -1;
  }
}
