public class Solution {
    /*
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        int n = triangle.length;
        int[] prev = new int[n];
        int[] cur = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    cur[j] = prev[j] + triangle[i][j];
                } else if (j == i) {
                    cur[j] = prev[j - 1] + triangle[i][j];
                } else {
                    cur[j] = Math.min(prev[j], prev[j - 1]) + triangle[i][j];
                }
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = res > prev[i] ? prev[i] : res;
        }
        return res;
    }
}
