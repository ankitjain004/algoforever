//@link{https://leetcode.com/problems/cheapest-flights-within-k-stops/solution/}
/*There are n cities connected by some number of flights.
You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi t
o city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
If there is no such route, return -1.*/

import java.util.Arrays;
import java.util.PriorityQueue;

class MinimumCostWithInKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] adj = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            adj[from][to] = price;
        }
        //Priority Queue will have first element as node, second as value and 3rd as no. of currentStops need to reach this particular node from source
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        //array to maintain minimum distance till now
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        //arrays to store minimum no of stop of you took to reach node i
        int[] currentStops = new int[n];
        Arrays.fill(currentStops, Integer.MAX_VALUE);
        dist[src] = 0;
        currentStops[src] = 0;
        pq.offer(new int[]{src, 0, 0});


        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int costForParentNode = curr[1];
            int numberOfStopForParentNode = curr[2];

            if (node == dst) return costForParentNode;

            if (numberOfStopForParentNode == k + 1) continue;

            //iterate for all the neighbours of curr

            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (adj[node][nextNode] > 0) {
                    int currentStopToReachI = currentStops[nextNode];
                    int currentCostToReachI = dist[nextNode];

                    if (costForParentNode + adj[node][nextNode] < dist[nextNode]) {
                        dist[nextNode] = adj[node][nextNode] + costForParentNode;

                        pq.offer(new int[]{nextNode, dist[nextNode], numberOfStopForParentNode + 1});
                    } else if (currentStops[nextNode] > numberOfStopForParentNode + 1) {
                        pq.offer(new int[]{nextNode, costForParentNode + adj[node][nextNode], numberOfStopForParentNode + 1});
                    }

                    currentStops[nextNode] = numberOfStopForParentNode + 1;  //this is important
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}