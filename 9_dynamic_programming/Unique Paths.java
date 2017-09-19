public class Solution {
    /*
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        int[] prev = new int[m];
        int[] cur = new int[m];
        Arrays.fill(prev, 1);
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    cur[j] = 1;
                } else {
                    cur[j] = cur[j - 1] + prev[j];
                }
            }
            int[] temp = prev;
            prev = cur;
            cur = prev;
        }
        return prev[m - 1];
    }
}
