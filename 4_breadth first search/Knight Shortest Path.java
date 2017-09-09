/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] addx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] addy = {2, -2, 2, -2, 1, -1, 1, -1};
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.offer(source.x * n + source.y);
        visited.add(source.x * n + source.y);
        int level = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == destination.x * n + destination.y) {
                    return level;
                }
                int curx = cur / n;
                int cury = cur % n;
                for (int j = 0; j < 8; j++) {
                    int nextx = curx + addx[j];
                    int nexty = cury + addy[j];
                    if (nextx < 0 || nextx >= m || nexty < 0 || nexty >= n 
                        || grid[nextx][nexty] 
                        || visited.contains(nextx * n + nexty)) {
                        continue;    
                    }
                    q.offer(nextx * n + nexty);
                    visited.add(nextx * n + nexty);
                }
            }
            level++;
        }
        return -1;
    }
    
}
