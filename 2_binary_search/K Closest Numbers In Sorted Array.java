public class Solution {
    
    /*
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length == 0 || A.length < k) {
            return null;
        }
        int[] res = new int[k];
        int cur = 0;
        // Get the closest numbers.
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        // Now add numbers to res.
        for (int i = 0; i < k; i++) {
            if (left < 0) {
                res[i] = A[right++];
            } else if (right >= A.length) {
                res[i] = A[left--];
            } else if (
                Math.abs(A[left] - target) <= Math.abs(A[right] - target)) {
                res[i] = A[left--];
            } else {
                res[i] = A[right++];
            }
        }
        return res;
    }
    
}
