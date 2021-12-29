/*//@link{https://leetcode.com/problems/course-schedule-ii/}
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them.
If it is impossible to finish all courses, return an empty array.*/

import java.util.*;
public class CourseScheduler {
    public int[] findOrder(int numCourses, int[][] pre) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[numCourses];
        Map<Integer, Integer> count = new HashMap();
        for (int i = 0; i < numCourses; i++) {


            count.put(i, 0);
            List<Integer> ans = new ArrayList<>();
            map.put(i, ans);
        }

        for (int i = 0; i < pre.length; i++) {
            Integer c1 = pre[i][0];
            Integer c2 = pre[i][1];
            putInMap(map, c1, c2);
            count.put(c1, count.get(c1) + 1);

        }

        int[] ans = new int[numCourses];
        int counter = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (count.get(i) == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int val = queue.poll();
            ans[counter++] = val;

            List<Integer> dependentCourse = map.get(val);
            for (Integer currentCourse : map.get(val)) {
                count.put(currentCourse, count.get(currentCourse) - 1);
                if (count.get(currentCourse) == 0)
                    queue.add(currentCourse);
            }
        }
        int[] vlank = new int[0];
        if (counter == numCourses) return ans;
        else return vlank;

    }

    public void putInMap(Map<Integer, List<Integer>> map, Integer c1, Integer c2) {
        map.get(c2).add(c1);
    }
}