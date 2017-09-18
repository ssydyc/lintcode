public class Vector2D implements Iterator<Integer> {
    
    private List<List<Integer>> vec2d;
    private Iterator<List<Integer>> nextList;
    private Iterator<Integer> nextNum;
    
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        nextList = vec2d.iterator();
        nextNum = nextList.next().iterator();
    }

    @Override
    public Integer next() {
        return nextNum.next();
    }

    @Override
    public boolean hasNext() {
        while (!nextNum.hasNext()) {
            if (nextList.hasNext()) {
                nextNum = nextList.next().iterator();
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
