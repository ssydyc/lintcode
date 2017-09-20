public class Solution {
    /*
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        int n = envelopes.length;
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(envelopes[i][0], envelopes[i][1]);
        }
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point point1, Point point2) {
                if (point1.x != point2.x) {
                    return point1.x - point2.x;
                } else {
                    return point2.y - point1.y;
                }
            }
        });
        return getMaxIncrease(points);
    }
    
    private int getMaxIncrease(Point[] points) {
        int n = points.length;
        int cur = 0;
        for (Point point : points) {
            if (cur == 0) {
                cur++;
            }
            int ind = getLargestSmaller(points, cur, point);
            points[ind + 1] = point;
            if (ind + 1 == cur) {
                cur++;
            }
        }
        return cur;
    }
    
    private int getLargestSmaller(Point[] points, int cur, Point point) {
        int left = 0;
        int right = cur - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (points[mid].y < point.y) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (points[right].y < point.y) {
            return right;
        } else if (points[left].y < point.y) {
            return left;
        } else {
            return -1;
        }
    }
    
    private class Point {
        private int x;
        private int y;
        
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
