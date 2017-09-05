public class Solution {
    
    /*
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        
        int left = 1;
        int right = x;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (right <= x / right) {
            return right;
        } else {
            return left;
        }
    }
    
}
