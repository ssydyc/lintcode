public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A == null) {
            A = new int[0];
        }
        if (B == null) {
            B = new int[0];
        }
        int n = A.length + B.length;
        if (n % 2 != 0) {
            return (double) helper(A, 0,  B, 0, n / 2);
        } else {
            return (double) (helper(A, 0, B, 0, n / 2 - 1) 
                + helper(A, 0, B, 0, n / 2))/ 2.0;
        }   
    }
    
    private int helper(int[] A, int aStart, int[] B, int bStart, int lessNum) {
        if (A.length == aStart) {
            return B[bStart + lessNum];
        }
        if (B.length == bStart) {
            return A[aStart + lessNum];
        }
        if (lessNum == 0) {
            return Math.min(A[aStart], B[bStart]);
        }
        if (lessNum == 1) {
            if (A[aStart] < B[bStart]) {
                return helper(A, aStart + 1, B, bStart, lessNum - 1);
            } else {
                return helper(A, aStart, B, bStart + 1, lessNum - 1);
            }
        }
        int aEnd = aStart + lessNum / 2 <= A.length 
            ? aStart + lessNum / 2 : A.length;
        int bEnd = bStart + lessNum / 2 <= B.length 
            ? bStart + lessNum / 2 : B.length;
        if (A[aEnd - 1] < B[bEnd - 1]) {
            return helper(A, aEnd, B, bStart, lessNum - (aEnd - aStart));
        } else {
            return helper(A, aStart, B, bEnd, lessNum - (bEnd - bStart));
        }
    }
}
