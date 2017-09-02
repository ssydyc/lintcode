public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    private boolean searchMatrixHelper(int[][] matrix, int row, int target) {
        int first = 0;
        int last = matrix[0].length - 1;
        
        while (first + 1 < last) {
            int mid = first + (last - first) / 2;
            
            if (matrix[row][mid] < target) {
                first = mid;
            } else {
                last = mid;
            }
        }
        
        if (matrix[row][first] == target || matrix[row][last] == target) {
            return true;
        }
        
        return false;
    }
     
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix.length == 0) {
            return 0;
        }
        
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            
            if (searchMatrixHelper(matrix, i, target)) {
                res++;
            }
        }
        
        return res;
    }
}
