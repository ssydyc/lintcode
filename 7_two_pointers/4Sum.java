public class Solution {
    /*
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        Arrays.sort(numbers);
        int n = numbers.length;
        
        for (int ind1 = 0; ind1 < n - 3; ind1++) {
            if (ind1 != 0 && numbers[ind1] == numbers[ind1 - 1]) {
                continue;
            }
            for (int ind2 = ind1 + 1; ind2 < n - 2; ind2++) {
                if (ind2 != ind1 + 1 && numbers[ind2] == numbers[ind2 - 1]) {
                    continue;
                }
                int ind3 = ind2 + 1;
                int ind4 = n - 1;
                while (ind3 < ind4) {
                    if (ind3 != ind2 + 1
                        && numbers[ind3] == numbers[ind3 - 1]) {
                        ind3++;
                        continue;
                    }
                    if (ind4 != n - 1 && numbers[ind4] == numbers[ind4 + 1]) {
                        ind4--;
                        continue;
                    }
                    int cur = numbers[ind1] + numbers[ind2] + numbers[ind3]
                        + numbers[ind4];
                    if (cur < target) {
                        ind3++;
                    } else if (cur > target) {
                        ind4--;
                    } else {
                        Integer[] temp = {numbers[ind1], numbers[ind2], numbers[ind3], numbers[ind4]};
                        res.add(Arrays.asList(temp));
                        ind3++;
                        ind4--;
                    }
                }
            }
        }
        return res;
    }
}
