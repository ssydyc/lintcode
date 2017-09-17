public class TwoSum {

    private Map<Integer, Integer> nums = new HashMap<>();
    
    public void add(int number) {
        if (!nums.containsKey(number)) {
            nums.put(number, 1);
        } else {
            nums.put(number, nums.get(number) + 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int num : nums.keySet()) {
            int remain = value - num;
            if (nums.containsKey(remain)) {
                if (remain == num && nums.get(remain) <= 1) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
    
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
