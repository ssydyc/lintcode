/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> res = new HashMap<>();
        if (results == null || results.length == 0) {
            return res;
        }
        Map<Integer, Queue<Integer>> topFive = new HashMap<>();
        for (Record record : results) {
            if (!topFive.containsKey(record.id)) {
                topFive.put(record.id, new PriorityQueue<Integer>());
            }
            Queue<Integer> cur = topFive.get(record.id);
            cur.offer(record.score);
            if (cur.size() > 5) {
                cur.poll();
            }
        }
        for (int key : topFive.keySet()) {
            Queue<Integer> cur = topFive.get(key);
            int sum = 0;
            while (!cur.isEmpty()) {
                sum += cur.poll();
            }
            res.put(key, sum / 5.0);
        }
        return res;
    }
}
