public class Solution {
    /*
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length <= 1) {
            return true;
        }
        int n = stones.length;
        boolean[][] res = new boolean[n][n];
        res[0][0] = true;
        
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (!res[i][j]) {
                    continue;
                }    
                if (i == 0 && j == 0) {
                    if (stones[1] == 1) {
                        res[0][1] = true;
                    } else {
                        continue;
                    }
                }
                int k = stones[j] - stones[i];
                int[] steps = {k - 1, k, k + 1};
                for (int step : steps) {
                    for (int next = j + 1; next < n; next++) {
                        if (stones[next] - stones[j] == step) {
                            res[j][next] = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (res[i][n - 1]) {
                return true;
            }
        }
        return false;
    }
}
