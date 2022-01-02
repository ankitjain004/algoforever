import java.util.Arrays;
import java.util.Stack;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int[][] merge(int[][] a) {
        Stack<Interval> stack = new Stack<>();
        int n = a.length;
        Arrays.sort(a, (a1, b1) -> Integer.compare(a1[0], b1[0]));

        Interval interval = new Interval(a[0][0], a[0][1]);
        stack.push(interval);
        for (int i = 1; i < n; i++) {
            Interval prev = stack.peek();

            //if currrent interval start lies in previous range
            if (prev.start <= a[i][0] && prev.end >= a[i][0]) {
                Interval now = new Interval(prev.start, Math.max(a[i][1], prev.end));
                stack.pop();
                stack.push(now);
            } else {
                stack.push(new Interval(a[i][0], a[i][1]));
            }
        }

        int stackSize = stack.size();

        int ans[][] = new int[stackSize][2];

        for (int i = stackSize - 1; i >= 0; i--) {
            Interval current = stack.pop();
            ans[i][0] = current.start;
            ans[i][1] = current.end;
        }

        return ans;

    }
}