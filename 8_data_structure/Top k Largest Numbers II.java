public class Solution {
    
    private int k;
    private Queue<Integer> topK;
    
    /*
    * @param k: An integer
    */public Solution(int k) {
        this.k = k;
        this.topK = new PriorityQueue<>(k);
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        if (topK.size() < k) {
            topK.offer(num);
        } else if (num > topK.peek()) {
            topK.poll();
            topK.offer(num);
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        Iterator it = topK.iterator();
        List<Integer> result = new ArrayList<Integer>();
        while (it.hasNext()) {
            result.add((Integer) it.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}
