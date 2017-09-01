public class Solution {
    
    /*
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target > A[right]) {
                if (A[mid] < target && A[mid] > A[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (A[mid] > target && A[mid] < A[right]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        if (A[left] == target) {
            return left;
        } else if (A[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
    
}
