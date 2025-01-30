/**
 * # Time complexity: O(V + E), where V is the number of courses (vertices) and E is the number of prerequisite pairs (edges).
 * # Space complexity: O(V + E), for storing the adjacency list and the indegree array.
 * # Leetcode: Yes
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegreeList = new int[numCourses];
        Queue<Integer> que = new LinkedList<>();
        int count = 0;

        for (int[] i : prerequisites) {
            int course = i[0];
            int prereq = i[1];

            indegreeList[course]++;

            map.putIfAbsent(prereq, new ArrayList<>());
            map.get(prereq).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegreeList[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int curr = que.poll();
            count++;

            List<Integer> edges = map.get(curr);
            if (edges == null) continue;

            for (int e : edges) {
                indegreeList[e]--;
                if (indegreeList[e] == 0) {
                    que.add(e);
                }
            }
        }

        return count == numCourses;
    }
}
