public class Solution {
    /*
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) {
            return new int[2];
        }
        Map<Integer, Integer> numIndex = new HashMap<>();
        int[] res = new int[2];
        
        for (int i = 0; i < numbers.length; i++) {
            if (numIndex.containsKey(target - numbers[i])) {
                res[0] = numIndex.get(target - numbers[i]) + 1;
                res[1] = i + 1;
            }
            numIndex.put(numbers[i], i);
        }
        return res;
    }
}
