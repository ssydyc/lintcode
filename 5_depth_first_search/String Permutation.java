public class Solution {
    /*
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) {
            return false;
        }
        int[] count = new int[128];
        for (int i = 0; i < A.length(); i++) {
            count[(int) A.charAt(i)]++;
        }
        for (int i = 0; i < B.length(); i++) {
            count[(int) B.charAt(i)]--;
        }
        for (int i = 0; i < 128; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
