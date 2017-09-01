class Solution {
    
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        int left = 0;
        int right = A.length - 2;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return A[left] < A[right] ? right : left;
    }
    
}
