public class Solution {
    /*
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {1, -1, 2, -2};
        int[] dy = {2, 2, 1, 1};
        int[][] reached = new int[m][n];
        for (int[] row : reached) {
            Arrays.fill(row, -1);
        }
        
        reached[0][0] = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (reached[i][j] == -1) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nextx = i + dx[k];
                    int nexty = j + dy[k];
                    if (nextx < 0 || nextx >= m 
                        || nexty < 0 || nexty >= n || grid[nextx][nexty]) {
                        continue;    
                    }
                    if (reached[nextx][nexty] == -1) {
                        reached[nextx][nexty] = reached[i][j] + 1;
                    } else {
                        reached[nextx][nexty] = Math.min(
                            reached[i][j] + 1, reached[nextx][nexty]);
                    }
                }
            }
        }
        return reached[m - 1][n - 1];
    }
}
