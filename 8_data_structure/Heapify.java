public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int n = A.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(A, i);
        }
    }
    
    private void heapify(int[] A, int start) {
        int n = A.length;
        int cur = start;
        int next = 2 * start + 1;
        while (2 * cur + 1 < n) {
            next = cur;
            if (A[cur] > A[2 * cur + 1]) {
                next = 2 * cur + 1;
            }
            if (2 * cur + 2 < n && A[next] > A[2 * cur + 2]) {
                next = 2 * cur + 2;
            }
            if (next == cur) {
                break;
            }
            swap(A, cur, next);
            cur = next;
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
