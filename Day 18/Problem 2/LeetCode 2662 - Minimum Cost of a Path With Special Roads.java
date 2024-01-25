class Solution {
  public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
    return dijkstra(specialRoads, start[0], start[1], target[0], target[1]);
  }

  private int dijkstra(int[][] specialRoads, int srcX, int srcY, int dstX, int dstY) {
    final int n = specialRoads.length;
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparing(Pair::getKey));

    for (int u = 0; u < n; ++u) {
      final int x1 = specialRoads[u][0];
      final int y1 = specialRoads[u][1];
      final int cost = specialRoads[u][4];
      final int d = Math.abs(x1 - srcX) + Math.abs(y1 - srcY) + cost;
      dist[u] = d;
      minHeap.offer(new Pair<>(dist[u], u));
    }

    while (!minHeap.isEmpty()) {
      final int d = minHeap.peek().getKey();
      final int u = minHeap.poll().getValue();
      final int ux2 = specialRoads[u][2];
      final int uy2 = specialRoads[u][3];
      for (int v = 0; v < n; ++v) {
        if (v == u)
          continue;
        final int vx1 = specialRoads[v][0];
        final int vy1 = specialRoads[v][1];
        final int vcost = specialRoads[v][4];
        final int newDist = d + Math.abs(vx1 - ux2) + Math.abs(vy1 - uy2) + vcost;
        if (newDist < dist[v]) {
          dist[v] = newDist;
          minHeap.offer(new Pair<>(dist[v], v));
        }
      }
    }

    int ans = Math.abs(dstX - srcX) + Math.abs(dstY - srcY);
    for (int u = 0; u < n; ++u) {
      final int x2 = specialRoads[u][2];
      final int y2 = specialRoads[u][3];
      ans = Math.min(ans, dist[u] + Math.abs(dstX - x2) + Math.abs(dstY - y2));
    }
    return ans;
  }
}