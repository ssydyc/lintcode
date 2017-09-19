public class Solution {
    /*
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        if (words == null || words.length == 0 || k == 0) {
            return new String[0];
        }
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (!count.containsKey(word)) {
                count.put(word, 1);
            } else {
                count.put(word, count.get(word) + 1);
            }
        }
        Queue<WordCount> topK = new PriorityQueue<WordCount>(k, 
            new Comparator<WordCount>() {
            @Override
            public int compare(WordCount wc1, WordCount wc2) {
                if (wc1.freq != wc2.freq) {
                    return wc1.freq - wc2.freq;
                } else {
                    return wc2.word.compareTo(wc1.word);
                }
            }
        });
        for (String key : count.keySet()) {
            if (topK.size() == k) {
                if (count.get(key) > topK.peek().freq 
                    || (count.get(key) == topK.peek().freq 
                        && key.compareTo(topK.peek().word) < 0)) {
                    topK.poll();
                    topK.offer(new WordCount(key, count.get(key)));    
                }
            } else {
                topK.offer(new WordCount(key, count.get(key)));
            }
        }
        
        // Add all words to res;
        String[] res = new String[k];
        int cur = k - 1;
        while (!topK.isEmpty()) {
            res[cur--] = topK.poll().word;
        }
        return res;
    }
    
    private class WordCount {
        private String word;
        private int freq;
        
        private WordCount(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
}
