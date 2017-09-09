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
        int res = Integer.MAX_VALUE;
        int[] equalXNum = new int[n];
        int[] equalYNum = new int[m];
        
        // Get equalXNum and equalYNum.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                equalXNum[j] += grid[i][j];
                equalYNum[i] += grid[i][j];
            }
        }
        
        int[] xPreSum = getPreSum(equalXNum, false);
        int[] xPostSum = getPreSum(equalXNum, true);
        int[] yPreSum = getPreSum(equalYNum, false);
        int[] yPostSum = getPreSum(equalYNum, true);
        int[] xPreDist = getPreDistance(xPreSum);
        int[] xPostDist = getPreDistance(xPostSum);
        int[] yPreDist = getPreDistance(yPreSum);
        int[] yPostDist = getPreDistance(yPostSum);
        
        // Get the minimum distance.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res = Math.min(res, xPreDist[j] + xPostDist[n - 1 - j]
                        + yPreDist[i] + yPostDist[m - 1 - i]);
                }
            }
        }
        return res;
    }
    
    private int[] getPreSum(int[] nums, boolean reverse) {
        int n = nums.length;
        int[] prevSum = new int[n + 1]; 
        if (!reverse) {
            for (int i = 0; i < n; i++) {
                prevSum[i + 1] = nums[i] + prevSum[i];
            }
        } else {
            for (int i = 0; i < n; i++) {
                prevSum[i + 1] = prevSum[i] + nums[n - 1 - i];
            }
        }
        return prevSum;
    }
    
    private int[] getPreDistance(int[] prevSum) {
        int[] preDistance = new int[prevSum.length - 1];
        for (int i = 1; i < preDistance.length; i++) {
            preDistance[i] = preDistance[i - 1] + prevSum[i];
        }
        return preDistance;
    }
    
}
