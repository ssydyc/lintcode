/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


public class Solution {
    
    /*
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        int[][] unionSet = new int[n][m];
        List<Integer> res = new ArrayList<>();
        int cur = 0;
        if (operators == null) {
            return res;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                unionSet[i][j] = -1;
            }
        }
        
        for (Point operator : operators) {
            if (unionSet[operator.x][operator.y] == -1) {
                cur += addChangeIslands(unionSet, operator.x, operator.y);
            }
            res.add(cur);
        }
        return res;
    }
    
    private int addChangeIslands(int[][] unionSet, int x, int y) {
        int[] addx = {0, 0, -1, 1};
        int[] addy = {-1, 1, 0, 0};
        int m = unionSet.length;
        int n = unionSet[0].length;
        unionSet[x][y]= x * n + y;
    
        int res = 1;
        for (int i = 0; i < 4; i++) {
            int nextx = x + addx[i];
            int nexty = y + addy[i];
            if (nextx < 0 || nextx >= m || nexty < 0 || nexty >=n 
                || unionSet[nextx][nexty] == -1) {
                continue;
            }
            int cur = getRoot(unionSet, x, y);
            int next = getRoot(unionSet, nextx, nexty);
            if (cur != next) {
                unionSet[cur / n][cur % n] = next;
                res--;
            }
        }
        return res;
    }
    
    private int getRoot(int[][] unionSet, int x, int y) {
        int m = unionSet.length;
        int n = unionSet[0].length;
        while (unionSet[x][y] != x * n + y) {
            int next = unionSet[x][y];
            x = next / n;
            y = next % n;
        }
        return unionSet[x][y];
    }
    
}
