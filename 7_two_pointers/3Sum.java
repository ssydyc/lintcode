public class Solution {
    /*
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return res;
        }
        int n = numbers.length;
        Arrays.sort(numbers);
        
        for (int left = 0; left < n - 2; left++) {
            if (left != 0 && numbers[left] == numbers[left - 1]) {
                continue;
            }
            int mid = left + 1;
            int right = n - 1;
            while (mid < right) {
                if (mid != left + 1 && numbers[mid] == numbers[mid - 1]) {
                    mid++;
                    continue;
                }
                int cur = numbers[left] + numbers[mid] + numbers[right];
                if (cur < 0) {
                    mid++;
                } else if (cur > 0) {
                    right--;
                } else {
                    Integer[] temp = {
                        numbers[left], numbers[mid], numbers[right]};
                    res.add(Arrays.asList(temp));
                    mid++;
                }
            }
        }
        return res;
    }
}
