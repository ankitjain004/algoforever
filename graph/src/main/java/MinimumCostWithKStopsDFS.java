import java.util.HashMap;
import java.util.Map;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class MinimumCostWithKStopsDFS {
    Map<Pair, Long> memo = new HashMap();
    int total;
    private int[][] adjMatrix;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        total = n;
        adjMatrix = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            adjMatrix[from][to] = price;
        }
        //map of src stop value like reach src with 3 stops left with price 700
        long ans = recurse(src, k, dst);
        return ans >= Integer.MAX_VALUE ? -1 : (int) ans;
    }


    public long recurse(int current, int k, int destination) {
        if (current == destination)
            return 0;

        if (k < 0) //since 1 stop means 2 journey k stop means k+1 journey
            return Integer.MAX_VALUE;

        Pair pair = new Pair(current, k);

        if (memo.containsKey(pair)) {
            return memo.get(pair);
        }
        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < total; i++) {
            if (adjMatrix[current][i] > 0) {
                ans = Math.min(ans, recurse(i, k - 1, destination) + adjMatrix[current][i]);
            }
        }

        memo.put(pair, ans);
        return ans;
    }
}