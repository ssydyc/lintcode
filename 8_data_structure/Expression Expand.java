public class Solution {
    /*
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ']') {
                LinkedList<Character> toAdd = new LinkedList<>();
                char cur = ']';
                while (cur != '[') {
                    cur = stack.pop();
                    toAdd.addFirst(cur);
                }
                toAdd.removeFirst();
                int rep = getNum(stack);
                for (int j = 0; j < rep; j++) {
                    for (char curChar : toAdd) {
                        stack.push(curChar);
                    }
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
    
    private int getNum(Stack<Character> stack) {
        int cur = 1;
        int res = 0;
        while (!stack.isEmpty() 
            && stack.peek() <= '9' && stack.peek() >= '0') {
            res += (stack.pop() - '0') * cur;
            cur *= 10;
        }
        return res;
    }
}
