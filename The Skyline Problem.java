import java.util.*;

class Solution {
  public List<List<Integer>> getSkyline(int[][] buildings) {
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < buildings.length; i++) {
      Point p1 = new Point(buildings[i][0], buildings[i][2], true);
      Point p2 = new Point(buildings[i][1], buildings[i][2], false);
      points.add(p1);
      points.add(p2);
    }
    Collections.sort(points, new Comparator<Point>() {
      public int compare(Point p1, Point p2) {
        if (p1.x != p2.x) {
            return p1.x - p2.x;
        }
        if (p1.isStart == true && p2.isStart == true) {
          return p2.y - p1.y;
        }
        if (p1.isStart == false && p2.isStart == false) {
          return p1.y - p2.y;
        }
        return p1.isStart ? -1 : 1;
      }
    });
    List<List<Integer>> res = new ArrayList<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    maxHeap.add(0);
    int maxVal = 0;
    for (Point p : points) {
      if (p.isStart) {
        maxHeap.add(p.y);
        if (maxHeap.peek() != maxVal) {
          res.add(new ArrayList<Integer>(Arrays.asList(p.x, p.y)));
        }
        maxVal = maxHeap.peek();
      } else {
        maxHeap.remove(p.y);
        if (maxHeap.peek() != maxVal) {
          res.add(new ArrayList<Integer>(Arrays.asList(p.x, maxHeap.peek())));
        }
        maxVal = maxHeap.peek();
      }
    }
    return res;
  }
}

class Point {
  int x;
  int y;
  boolean isStart;

  Point(int x, int y, boolean isStart) {
    this.x = x;
    this.y = y;
    this.isStart = isStart;
  }
}
