import java.util.PriorityQueue;

class MedianFinder {
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  boolean isEven = true;

  public MedianFinder() {

  }

  public void addNum(int num) {
    if (isEven) {
      maxHeap.add(num);
      minHeap.add(maxHeap.remove());
    } else {
      minHeap.add(num);
      maxHeap.add(minHeap.remove());
    }
    isEven = !isEven;
  }

  public double findMedian() {
    if (isEven) {
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    } else {
      return minHeap.peek();
    }
  }
}
