public class Solution {
    /*
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];
        int[] cur = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    cur[j] = prev[j] + grid[i][j];
                } else if (i == 0) {
                    cur[j] = cur[j - 1] + grid[i][j];
                } else {
                    cur[j] = Math.min(prev[j], cur[j - 1]) + grid[i][j];
                }
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }
        
        return prev[n - 1];
    }
}
