public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        int n = A.length;
        Map<Integer, Integer> count = new HashMap<>();
        long multiplier = 1;
        long replica = 1;
        long res = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            int larger = 0;
            if (count.containsKey(A[i])) {
                count.put(A[i], count.get(A[i]) + 1);
            } else {
                count.put(A[i], 1);
            }
            replica *= count.get(A[i]);
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[i]) {
                    larger++;
                }
            }
            res += larger * multiplier / replica;
            multiplier *= n - i;
        }
        return res;
    }
}
