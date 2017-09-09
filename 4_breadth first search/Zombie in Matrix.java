public class Solution {
    
    /*
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int time = -1;
        Queue<Integer> q = new LinkedList<>();
        
        // Add all zombies first.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(i * n + j);
                }
            }
        }
        
        // Run BFS to change people to zombies.
        int level = 0;
        int[] addx = {-1, 1, 0, 0};
        int[] addy = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                int curx = cur / n;
                int cury = cur % n;
                grid[curx][cury] = 1;
                time = level;
                for (int j = 0; j < 4; j++) {
                    int nextx = curx + addx[j];
                    int nexty = cury + addy[j];
                    if (nextx < 0 || nextx >= m || nexty < 0 || nexty >= n
                        || grid[nextx][nexty] != 0) {
                            continue;
                    }
                    grid[nextx][nexty] = 1;
                    q.offer(nextx * n + nexty); 
                }
            }
            level++;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    return -1;
                }
            }
        }
        return time;
    }
    
}
