public class Solution {
    
    private enum Direction {
        LEFT, RIGHT, TOP, BOTTOM
    }
    
    /*
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0) {
            return 0;
        }
        
        int[] bounds = new int[4];
        Direction[] directions = {
            Direction.LEFT, Direction.RIGHT, Direction.TOP, Direction.BOTTOM};
        int[] xys = {x, x, y, y};
        
        for (int i = 0; i < directions.length; i++) {
            bounds[i] = getBound(directions[i], xys[i], image);
        }
        return (bounds[1] - bounds[0] + 1) * (bounds[3] - bounds[2] + 1);
    }
    
    private int getBound(Direction direction, int x, char[][] image) {
        int left = 0;
        int right = 0;
        int m = image.length;
        int n = image[0].length;
        
        if (direction == Direction.LEFT || direction == Direction.TOP) {
            right = x;
        } else {
            left = x;
            right = direction == Direction.RIGHT ? m - 1 : n - 1; 
        }
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (containsBlack(image, mid, direction)) {
                if (direction == Direction.LEFT || direction == Direction.TOP) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (direction == Direction.LEFT || direction == Direction.TOP) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        
        if (direction == Direction.LEFT || direction == Direction.TOP) {
            return containsBlack(image, left, direction) ? left : right;
        } else {
            return containsBlack(image, right, direction) ? right : left;
        }
    }
    
    private boolean containsBlack(char[][] image, int x, Direction direction) {
        if (direction == Direction.LEFT || direction == Direction.RIGHT) {
            for (int i = 0; i < image[0].length; i++) {
                if (image[x][i] == '1') {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 0; i < image.length; i++) {
                if (image[i][x] == '1') {
                    return true;
                }
            }
            return false;
        }
    }
    
}
