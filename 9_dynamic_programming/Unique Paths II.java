public class Solution {
    /*
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];
        int[] cur = new int[n];
        
        // Initilize prev.
        prev[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                prev[i] = 0;
            } else {
                prev[i] = prev[i - 1];
            }
        }
        
        // Run dynamic programming.
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    cur[j] = 0;
                } else if (j == 0) {
                    cur[j] = prev[j];
                } else {
                    cur[j] = prev[j] + cur[j - 1];
                }
            }
            int[] temp = cur;
            cur = prev;
            prev = temp;
        }
        return prev[n - 1];
    }
}
