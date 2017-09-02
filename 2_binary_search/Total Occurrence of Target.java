public class Solution {
    
    /*
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int leftIndex = helper(A, target, true);
        int rightIndex = helper(A, target, false); 
        if (leftIndex == -1) {
            return 0;
        } else {
            return rightIndex - leftIndex + 1;
        }
    }
    
    private int helper(int[] A, int target, boolean leftmost) {
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < target) {
                left = mid;
            } else if (A[mid] > target) {
                right = mid;
            } else {
                if (leftmost) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        if (leftmost) {
            if (A[left] == target) {
                return left;
            } else if (A[right] == target) {
                return right;
            }
        } else {
            if (A[right] == target) {
                return right;
            } else if (A[left] == target) {
                return left;
            }
        }
        
        return -1;
    }
    
}
