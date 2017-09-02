public class Solution {
    
    /*
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // First handle with special cases.
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }
        long longDividend = (long) dividend;
        long longDivisor = (long) divisor;
        int sign = 1;
        if (longDividend < 0) {
            longDividend = -longDividend;
            sign *= -1;
        }
        if (longDivisor < 0) {
            longDivisor = -longDivisor;
            sign *= -1;
        }
        int res = helper(longDividend, longDivisor);
        return sign == 1 ? res : -res; 
    }
    
    /**
     * This is helper function to find division where divisor is guaranteed to
     * be positive.
     */
    private int helper(long dividend, long divisor) {
        long curNum = divisor;
        int curAdd = 1;
        int res = 0;
        while (curNum <= (dividend >> 1)) {
            curNum = (curNum << 1);
            curAdd = (curAdd << 1);
        }
        while (curAdd > 0) {
            if (curNum <= dividend) {
                dividend -= curNum;
                res += curAdd;
            }
            curNum = (curNum >> 1);
            curAdd = (curAdd >> 1);
        }
        return res;
    }
    
}
