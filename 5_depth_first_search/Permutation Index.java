public class Solution {
    /*
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        if (A == null || A.length <= 1) {
            return 1;
        }
        int n = A.length;
        long factorial = 1;
        long res = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
            res += factorial * count;
            factorial *= n - i;
        }
        
        return res;
    }
}

// 1 4 2
// 4 1 2
