public class Solution {
    
    /**
     * @param n an integer
     * @return an integer
     */
    public int dropEggs(int n) {
        // Write your code here
        long ans = 0;
        for (int i = 1; ; i++) {
            ans += i;
            if (ans >= n) {
                return i; 
            }
        }
    }
    
}
