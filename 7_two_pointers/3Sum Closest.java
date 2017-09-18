public class Solution {
    /*
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        Arrays.sort(numbers);
        int n = numbers.length;
        int closest = Integer.MAX_VALUE;
        int res = 0;
        
        for (int left = 0; left < n - 2; left++) {
            int mid = left + 1;
            int right = n - 1;
            while (mid < right) {
                int cur = numbers[left] + numbers[mid] + numbers[right];
                if (cur < target) {
                    mid++;
                } else {
                    right--;
                }
                if (Math.abs(cur - target) < closest) {
                    closest = Math.abs(cur - target);
                    res = cur;
                }
            }
        }
        return res;
    }
}
