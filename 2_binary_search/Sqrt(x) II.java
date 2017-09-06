public class Solution {
    
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        double left = 0;
        double right = (x + 1.0) / 2;
        double epsilon = Double.parseDouble("1.0E-10");

        while (right - left > epsilon) {
            double mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
    
}
