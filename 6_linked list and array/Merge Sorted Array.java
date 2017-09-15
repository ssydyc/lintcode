public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int ind1 = m - 1;
        int ind2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (ind1 < 0) {
                A[i] = B[ind2--];
            } else if (ind2 < 0) {
                A[i] = A[ind1--];
            } else if (A[ind1] < B[ind2]){
                A[i] = B[ind2--];
            } else {
                A[i] = A[ind1--];
            }
        }
    }
}
