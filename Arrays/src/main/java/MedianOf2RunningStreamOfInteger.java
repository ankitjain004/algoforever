import java.util.Collections;
import java.util.PriorityQueue;
//when I was writing this code , the mistake I was making is assuming that default is a max heap whereas it is a minheap with min-element at top
public class MedianOf2RunningStreamOfInteger {
    PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder()); //left
    PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>(); //right
    public MedianOf2RunningStreamOfInteger() {

    }

    public void addNum(int num) {
        //base case
        if(maxPQ.size()==0)
        {
            maxPQ.add(num);
            return;
        }
        //simply add and then balance the heap to have a max difference of 1 . No need to worry if left is 1 more or right is 1 more
        //that we can check when returni8ng the median
        if(num<=maxPQ.peek())
        {
            maxPQ.add(num);

            int leftSize = maxPQ.size();
            int rightSize = minPQ.size();

            if(leftSize>rightSize+1)
            {
                minPQ.add(maxPQ.poll());
            }
        }
        else
        {
            minPQ.add(num);
            int leftSize = maxPQ.size();
            int rightSize = minPQ.size();
            if(leftSize+1 <rightSize )
            {
                maxPQ.add(minPQ.poll());
            }
        }
    }

    public double findMedian() {
        if(maxPQ.size() == minPQ.size())
        {
            int maxFromLeft = minPQ.peek();
            int minFromRight = maxPQ.peek();
            return (double)(maxFromLeft+minFromRight)/2;

        }
        else if(minPQ.size()>maxPQ.size())
        {
            int top = minPQ.peek();
            return top;
        }
        else
        {
            int top = maxPQ.peek();
            return top;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
