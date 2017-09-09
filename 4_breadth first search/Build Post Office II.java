public class Solution {
    /*
     * @param grid: a 2D grid
     * @return: An integer
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int houseNum = 0;
        int res = -1;
        NodeInfo[][] nodes = new NodeInfo[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = new NodeInfo(0, 0);
            }
        }
        
        // Get the total distance.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    houseNum++;
                    BFS(grid, i, j, nodes);
                }
            }
        }
        
        // Return max distance.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 || nodes[i][j].times != houseNum) {
                    continue;
                }
                if (res == -1) {
                    res = nodes[i][j].distance;
                } else {
                    res = Math.min(res, nodes[i][j].distance);
                }
            }
        }
        return res;
    }
    
    private void BFS(int[][] grid, int startx, int starty, NodeInfo[][] nodes) {
        int m = grid.length;
        int n = grid[0].length;
        int[] addx = {-1, 1, 0, 0};
        int[] addy = {0, 0, -1, 1};
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.offer(startx * n + starty);
        visited.add(startx * n + starty);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                int curx = cur / n;
                int cury = cur % n;
                for (int j = 0; j < 4; j++) {
                    int nextx = curx + addx[j];
                    int nexty = cury + addy[j];
                    if (nextx < 0 || nextx >= m || nexty < 0 || nexty >= n
                        || grid[nextx][nexty] != 0 
                        || visited.contains(nextx * n + nexty)) {
                        continue;    
                    }
                    visited.add(nextx * n + nexty);
                    q.offer(nextx * n + nexty);
                    nodes[nextx][nexty].distance += level;
                    nodes[nextx][nexty].times++;
                }
            }
        }
    }
    
    private class NodeInfo {
        
        private int distance;
        private int times;
        
        private NodeInfo(int distance, int times) {
            this.distance = distance;
            this.times = times;
        }
        
    }
    
}
