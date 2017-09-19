/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {

    LinkedList<NestedInteger> deque = new LinkedList<>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger temp : nestedList) {
            deque.add(temp);
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        hasNext();
        return deque.removeFirst().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        while (!deque.isEmpty() && !deque.getFirst().isInteger()) {
            NestedInteger cur = deque.removeFirst();
            List<NestedInteger> next = cur.getList();
            deque.addAll(0, next);
        }
        return !deque.isEmpty();
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */
