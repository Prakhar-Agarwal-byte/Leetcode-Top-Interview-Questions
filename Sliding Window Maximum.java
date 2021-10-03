import java.util.*;

class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> q = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      while (!q.isEmpty() && q.peekLast() < nums[i]) {
        q.removeLast();
      }
      q.addLast(nums[i]);
      if (i >= k - 1) {
        list.add(q.peekFirst());
        if (nums[i - k + 1] == q.peekFirst()) {
          q.removeFirst();
        }
      }
    }
    int[] res = new int[list.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = list.get(i);
    }
    return res;
  }
}
