public class ZigzagIterator {
    
    private Iterator<Integer> list1;
    private Iterator<Integer> list2;
    private boolean isList1;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.list1 = v1.iterator();
        this.list2 = v2.iterator();
        this.isList1 = true;
        if (!list1.hasNext()) {
            isList1 = false;
        }
    }

    /*
     * @return: An integer
     */
    public int next() {
        int res;
        if (isList1) {
            res = list1.next();
        } else {
            res = list2.next();
        }
        isList1 = !isList1;
        if (!list1.hasNext()) {
            isList1 = false;
        }
        if (!list2.hasNext()) {
            isList1 = true;
        }
        return res;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        return (list1.hasNext() || list2.hasNext());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
