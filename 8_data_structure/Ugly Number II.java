public class Solution {
    /*
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        List<LinkedList<Integer>> candidate = new ArrayList<>();
        int[] factor = {2, 3, 5};
        for (int i = 0; i < 3; i++) {
            candidate.add(new LinkedList<Integer>());
            candidate.get(i).add(factor[i]);
        }
        int res = 1;
        for (int i = 2; i <= n; i++) {
            int next = getMinimum(candidate);
            while (next == res) {
                next = getMinimum(candidate);
            }
            res = next;
            for (int j = 0; j < candidate.size(); j++) {
                candidate.get(j).add(res * factor[j]);
            }
        }
        return res;
    }
    
    private int getMinimum(List<LinkedList<Integer>> candidate) {
        int minIndex = -1;
        int minVal = Integer.MAX_VALUE;
        int[] factor = {2, 3, 5};
        
        for (int i = 0; i < candidate.size(); i++) {
            if (candidate.get(i).get(0) < minVal) {
                minIndex = i;
                minVal = candidate.get(i).get(0);
            }
        }
        candidate.get(minIndex).removeFirst();
        return minVal;
    }
}
