public class Solution {
    
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null 
            || prerequisites.length == 0) {
            return true;
        }
        int finished = 0;
        int[] incomingNums = new int[numCourses];
        Stack<Integer> noIncoming = new Stack<>();
        List<List<Integer>> graph = new ArrayList<>();
        
        // Create graph.
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            incomingNums[prerequisites[i][0]]++;
        }
        for (int i = 0; i < incomingNums.length; i++) {
            if (incomingNums[i] == 0) {
                noIncoming.push(i);
                finished++;
            }
        }
        
        // Add course one by one.
        while (!noIncoming.isEmpty()) {
            int cur = noIncoming.pop();
            for (int nextCourse : graph.get(cur)) {
                incomingNums[nextCourse]--;
                if (incomingNums[nextCourse] == 0) {
                    noIncoming.push(nextCourse);
                    finished++;
                }
            }
        }
        
        return finished == numCourses;
    }
    
}
