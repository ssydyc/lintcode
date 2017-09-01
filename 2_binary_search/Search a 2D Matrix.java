public class Solution {
    
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] > target || matrix[i][n - 1] < target) {
                continue;
            }
            
            // Binary search on the row.
            int left = 0;
            int right = n - 1;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (matrix[i][mid] <= target) {
                    left = mid;
                }  else {
                    right = mid;
                }
            }
            if (matrix[i][left] == target || matrix[i][right] == target) {
                return true;
            }
        }
        return false;
    }
    
}
