public class Solution {
    /*
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        if (S == null || S.length < 3) {
             return 0;
        }
        int n = S.length;
        Arrays.sort(S);
        
        int res = 0;
        for (int i = n - 1; i >= 2; i--) {
            int target = S[i];
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int cur = S[left] + S[right];
                if (cur <= target) {
                    left++;
                } else {
                    res += right - left;
                    right--;
                }
            }
        }
        return res;
    }
}
