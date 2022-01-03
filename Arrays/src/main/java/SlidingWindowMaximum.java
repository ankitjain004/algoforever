/*You are given an array of integers nums, there is a sliding window of size k which
is moving from the very left of the array to the very right. You can only see the k numbers in the window.
Each time the sliding window moves right by one position.
Return the max sliding window.*/


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {

    public static List<Integer> findMaximumInEveryWindow(int[] arr, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int n = arr.length;
        if (n == 0 || k > n) return ans;
        dq.addLast(0);
        for (int i = 1; i < k; i++)  //put a check to have k greater than n
        {
            int val = arr[i];
            while (!dq.isEmpty() && arr[dq.peekLast()] < val) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans.add(arr[dq.peekFirst()]);

        for (int i = k; i < n; i++) {
            int val = arr[i];
            //out of range
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && arr[dq.peekLast()] < val) {
                dq.removeLast();
            }
            dq.addLast(i);
            ans.add(arr[dq.peekFirst()]);
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 9, 11, 15, 1};
        int k = 3;
        //4,4,9,11,15,15
        List<Integer> maximumInEveryWindow = SlidingWindowMaximum.findMaximumInEveryWindow(arr, k);
        System.out.println(maximumInEveryWindow);

    }
}
