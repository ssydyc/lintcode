public class ZigzagIterator2 {
    
    private List<Iterator<Integer>> iterators;
    int curList;
    int k;
    /**
     * @param vecs a list of 1d vectors
     */
    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        this.k = vecs.size();
        this.iterators = new ArrayList<>();
        
        for (ArrayList<Integer> vec : vecs) {
            iterators.add(vec.iterator());
        }
        for (int i = 0; i < k; i++) {
            if (iterators.get(i).hasNext()) {
                curList = i;
                break;
            }
        }
    }

    public int next() {
        int res = iterators.get(curList).next();
        curList++;
        curList = curList % k;
        for (int i = 0; i < k; i++) {
            int cur = (curList + i) % k;
            if (iterators.get(cur).hasNext()) {
                curList = cur;
                break;
            }
        }
        return res;
    }

    public boolean hasNext() {
        return iterators.get(curList).hasNext();
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
