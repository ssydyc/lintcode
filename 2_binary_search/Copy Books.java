public class Solution {
    
    /*
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int sum = getSum(pages);
        int left = sum / k;
        int right = sum;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (canCopy(pages, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (canCopy(pages, k, left)) {
            return left;
        } else {
            return right;
        }
    }
    
    private int getSum(int[] pages) {
        int res = 0;
        for (int page : pages) {
            res += page;
        }
        return res;
    }
    
    private boolean canCopy(int[] pages, int k, int min) {
        int people = 0;
        int curPages = 0;
        for (int page : pages) {
            if (page > min) {
                return false;
            }
            if (curPages + page > min) {
                people++;
                curPages = page;
            } else {
                curPages += page;
            }
        }
        if (curPages > 0) {
            people++;
        }
        return people <= k;
    }
    
}
