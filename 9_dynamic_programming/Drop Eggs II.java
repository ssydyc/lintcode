public class Solution {
    /*
     * @param m: the number of eggs
     * @param n: the number of floors
     * @return: the number of drops in the worst case
     */
    public int dropEggs2(int m, int n) {
        if (n <= 0 || m <= 0) {
            return 0;
        }
        // First index egg, second floor.
        int[][] res = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            res[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            res[1][i] = i;
        }
        
        // Find the final res;
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                // Drop first egg at the kth floor.
                for (int k = 1; k <= j; k++) {
                    int val = 1 + Math.max(res[i - 1][k - 1], res[i][j - k]);
                    if (res[i][j] == 0 || val < res[i][j]) {
                        res[i][j] = val;
                    }
                }
            }
        }
        return res[m][n];
    }
}
