import java.util.*;

class Solution {
  public int maxPoints(int[][] points) {
    int solution = 0;
    for (int i = 0; i < points.length; i++) {
      Map<String, Integer> map = new HashMap<>();
      int duplicate = 0;
      int max = 0;
      for (int j = i + 1; j < points.length; j++) {
        int deltaX = points[j][0] - points[i][0];
        int deltaY = points[j][1] - points[i][1];
        if (deltaX == 0 && deltaY == 0) {
          duplicate++;
          continue;
        }
        int gcd = gcd(deltaX, deltaY);
        int dx = deltaX / gcd;
        int dy = deltaY / gcd;
        String key = dx + " " + dy;
        map.put(key, map.getOrDefault(key, 0) + 1);
        max = Math.max(max, map.get(key));
      }
      solution = Math.max(solution, max + duplicate + 1);
    }
    return solution;
  }

  private int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }
}
