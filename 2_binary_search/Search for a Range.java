public class Solution {
    /*
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1, -1};
        if (A == null || A.length == 0) {
            return res;
        }
        res[0] = helper(A, target, true);
        res[1] = helper(A, target, false);
        return res;
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
