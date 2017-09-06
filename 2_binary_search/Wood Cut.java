public class Solution {
    
    /*
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }
        int left = 0;
        int right = getMax(L);
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (canCut(L, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (canCut(L, k, right)) {
            return right;
        } else {
            return left;
        }
    }
    
    private int getMax (int[] L) {
        int res = 0;
        for (int l : L) {
            if (l > res) {
                res = l;
            }
        }
        return res;
    }
    
    private boolean canCut(int[] L, int k, int length) {
        for (int l : L) {
            k -= l / length;
            if (k <= 0) {
                return true;
            }
        }
        return false;
    }
    
}
