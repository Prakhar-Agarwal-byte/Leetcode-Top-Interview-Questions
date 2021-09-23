import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode l1, ListNode l2) {
        if (l1.val > l2.val)
          return 1;
        if (l1.val < l2.val)
          return -1;
        return 0;
      }
    });
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        minHeap.add(lists[i]);
      }
    }
    ListNode d = new ListNode();
    ListNode cur = d;
    while (!minHeap.isEmpty()) {
      ListNode n = minHeap.poll();
      cur.next = n;
      cur = cur.next;
      n = n.next;
      if (n != null) {
        minHeap.add(n);
      }
    }
    return d.next;
  }
}
