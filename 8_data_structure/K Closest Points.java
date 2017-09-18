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
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        if (points == null || points.length == 0 || k <= 0) {
            return new Point[0];
        } 
        Queue<Point> closestK = new PriorityQueue<>(k + 1, 
            new Comparator<Point>() {
            @Override
            public int compare(Point point1, Point point2) {
                int dist1 = getDistanceSquare(point1, origin);
                int dist2 = getDistanceSquare(point2, origin);
                if (dist1 != dist2) {
                    return dist2 - dist1;
                } else {
                    return point2.x - point1.x;
                }
            }
        });
        for (Point point : points) {
            closestK.offer(point);
            if (closestK.size() > k) {
                closestK.poll();
            }
        }
        
        int cur = closestK.size() - 1;
        Point[] res = new Point[closestK.size()];
        while (!closestK.isEmpty()) {
            res[cur--] = closestK.poll();
        }
        return res;
    }
    
    private int getDistanceSquare(Point point1, Point point2) {
        return (point1.x - point2.x) * (point1.x - point2.x) 
                + (point1.y - point2.y) * (point1.y - point2.y);
    }
}
