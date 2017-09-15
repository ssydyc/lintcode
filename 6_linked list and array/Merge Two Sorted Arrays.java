public class Solution {
    /*
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if (A == null || A.length == 0) {
            return B;
        }
        if (B == null || B.length == 0) {
            return A;
        }
        int[] res = new int[A.length + B.length];
        int ind1 = 0;
        int ind2 = 0;
        for (int i = 0; i < res.length; i++) {
            if (ind1 == A.length) {
                res[i] = B[ind2++];
            } else if (ind2 == B.length) {
                res[i] = A[ind1++];
            } else if (A[ind1] < B[ind2]) {
                res[i] = A[ind1++];
            } else {
                res[i] = B[ind2++];
            }
        }
        return res;
    }
}
