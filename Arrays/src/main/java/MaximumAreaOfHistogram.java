import java.util.Stack;

class MaximumAreaOfHistogram {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int prevSmaller[] = new int[n];

        int[] prevsmaller = findPreviousSmaller( heights);

        int[] nextsmaller = findNextSmaller( heights);
        int maxArea =0;
        for(int i=0;i<n;i++)
        {
            maxArea = Math.max(maxArea, (nextsmaller[i]-prevsmaller[i]+1)*heights[i]);
        }
        return maxArea;
    }

    public int[] findNextSmaller(int [] heights)
    {
        int n = heights.length;
        int[] nextsmaller = new int[n];
        Stack<Integer> stk = new Stack();
        for(int i=n-1;i>=0;i--)
        {
            while(!stk.empty() && heights[stk.peek()] >= heights[i])
                stk.pop();

            nextsmaller[i] = stk.empty()==true ? n-1 : stk.peek()-1;
            stk.push(i);
        }
        return nextsmaller ;

    }

    public int[] findPreviousSmaller( int[] heights)
    {
        int n = heights.length;
        int[] prevsmaller = new int[n];
        Stack<Integer> stk = new Stack();
        for(int i=0;i<n;i++)
        {
            while(!stk.empty() && heights[stk.peek()]>=heights[i])
            {
                stk.pop();
            }
            prevsmaller[i] = stk.empty()==true ?0: stk.peek()+1;
            stk.push(i);
        }

        return prevsmaller;
    }
}