public class Solution {
    
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void bfs(boolean[][] grid, int starti, int startj) {
        int m = grid.length;
        int n = grid[0].length;
        int[] addx = {0, 0, -1, 1};
        int[] addy = {-1, 1, 0, 0};
        Queue<Integer> q = new LinkedList<>();
        q.offer(starti * n + startj);
        grid[starti][startj] = false;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                int curx = cur / n;
                int cury = cur % n;
                for (int j = 0; j < 4; j++) {
                    int nextx = curx + addx[j];
                    int nexty = cury + addy[j];
                    if (nextx < 0 || nextx >= m || nexty < 0 || nexty >= n 
                        || !grid[nextx][nexty]) {
                        continue;    
                    }
                    grid[nextx][nexty] = false;
                    q.offer(nextx * n + nexty);
                }
            }
        }
    }
    
}
