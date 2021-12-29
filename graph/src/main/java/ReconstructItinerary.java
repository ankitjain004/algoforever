import java.util.*;

public class ReconstructItinerary {
    Map<String, List<String>> map = new HashMap();
    HashMap<String, boolean[]> visitBitmap = new HashMap<>();
    int flights = 0;
    List<String> result = null;


    public List<String> findItinerary(List<List<String>> tickets) {
        //step 1 constructing adjacency list
        for (int i = 0; i < tickets.size(); i++) {
            List<String> currentTicket = tickets.get(i);
            String src = currentTicket.get(0);
            String dest = currentTicket.get(1);
            putInMap(map, src, dest);
            flights++;
        }
        //step 2 filling the visitBitMap
        for (Map.Entry<String, List<String>> entry : this.map.entrySet()) {
            Collections.sort(entry.getValue());
            this.visitBitmap.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }

        List<String> route = new ArrayList<>();
        route.add("JFK");

        // Step 3). backtracking
        this.backtracking("JFK", route);
        return this.result;

    }

    protected boolean backtracking(String origin, List<String> route) {
        if (route.size() == this.flights + 1) {
            return true;
        }

        if (!this.map.containsKey(origin))
            return false;

        int i = 0;
        boolean[] bitmap = this.visitBitmap.get(origin);

        for (String dest : this.map.get(origin)) {
            if (!bitmap[i]) {
                bitmap[i] = true;
                route.add(dest);
                boolean ret = this.backtracking(dest, route);
                route.remove(route.size() - 1);
                bitmap[i] = false;

                if (ret)
                    return true;
            }
            ++i;
        }

        return false;
    }

    public void putInMap(Map<String, List<String>> map, String origin, String dest) {
        if (this.map.containsKey(origin)) {
            List<String> destList = this.map.get(origin);
            destList.add(dest);
        } else {
            List<String> destList = new LinkedList<String>();
            destList.add(dest);
            this.map.put(origin, destList);
        }
    }
}
