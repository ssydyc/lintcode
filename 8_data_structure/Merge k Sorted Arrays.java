public class Solution {
    /*
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }
        int k = arrays.length;
        List<Integer> res = new ArrayList<>();
        Queue<NumIndex> minHeap = new PriorityQueue<>(k, 
            new Comparator<NumIndex>() {
            @Override
            public int compare(NumIndex numIndex1, NumIndex numIndex2) {
                return numIndex1.num - numIndex2.num;
            }
        });
        int[] index = new int[k];
        
        for (int i = 0; i < k; i++) {
            if (arrays[i].length != 0) {
                minHeap.offer(new NumIndex(arrays[i][index[i]], i));
            }
        }
        while (!minHeap.isEmpty()) {
            NumIndex cur = minHeap.poll();
            res.add(cur.num);
            int arrayIndex = cur.index;
            index[arrayIndex]++;
            if (index[arrayIndex] != arrays[arrayIndex].length) {
                minHeap.offer(
                    new NumIndex(arrays[arrayIndex][index[arrayIndex]],
                    arrayIndex));
            }
        }
        
        int[] arrayRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arrayRes[i] = res.get(i);
        }
        return arrayRes;
    }
    
    private class NumIndex {
        private int num;
        private int index;
        
        private NumIndex(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
