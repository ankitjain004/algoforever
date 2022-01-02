import java.util.*;

class ElemPair {
    String first;
    Double second;

    ElemPair(String node, Double value) {
        this.first = node;
        this.second = value;
    }

    public String getFirst() {
        return first;
    }

    public Double getSecond() {
        return second;
    }
}

class EvaluateDivision {
    Map<String, List<ElemPair>> map = new HashMap();
    Set<String> set = new HashSet();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String from = eq.get(0);
            String to = eq.get(1);
            Double cost = values[i];
            ElemPair elemPair = new ElemPair(to, cost);
            if (map.containsKey(from)) {
                map.get(from).add(elemPair);
            } else {
                List<ElemPair> pairList = new ArrayList();
                pairList.add(elemPair);
                map.put(from, pairList);
            }
            elemPair = new ElemPair(from, (double)1.0/(double)cost);
            if (!map.containsKey(to)) {
                List<ElemPair> pairList = new ArrayList();
                pairList.add(elemPair);
                map.put(to, pairList);
            }
            else {
                List<ElemPair> pairList = new ArrayList();
                pairList.add(elemPair);
                map.get(to).add(elemPair);
            }
        }
        double[] sol = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Map<String, Boolean> visited = new HashMap();
            List<String> query = queries.get(i);

            String from = query.get(0);
            visited.put(from, true);
            String to = query.get(1);
            if(!map.containsKey(from)||!map.containsKey(to))
            {
                sol[i] = -1.0;
            }
            else
            {
                Double ans = 1.0;
                List<Double> list = new ArrayList();
                sol[i] = dfs(from, to, ans, visited);
            }
        }
        return sol;
    }

    public Double dfs(String from, String to, Double ans, Map<String, Boolean> visited ) {
        if (from.equals(to)) {
            return ans;
        }

        if (!map.containsKey(from))
            return -1.0;


        for (ElemPair elemPair : map.get(from)) {
            String dest = elemPair.first;
            double cost = elemPair.second;
            if(!visited.containsKey(dest))
            {
                visited.put(dest, true);
                double solution = dfs(dest, to, ans * cost, visited);

                if (solution > 0.0)
                    return solution;
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
/*        [["a","b"],["b","c"]]
          [2.0,3.0]
          [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
*/
        List<List<String>> equations = new ArrayList<>();
        List<String> eq1 = new ArrayList<>();
        eq1.add("a");
        eq1.add("b");

        List<String> eq2 = new ArrayList<>();
        eq2.add("e");
        eq2.add("f");

        List<String> eq3 = new ArrayList<>();
        eq3.add("b");
        eq3.add("e");

        equations.add(eq1);
        equations.add(eq2);
        equations.add(eq3);
        double[] ans = new double[]{3.4,1.4,2.3};


        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>();
        q1.add("a");
        q1.add("g");
        queries.add(q1);

        EvaluateDivision evaluateDivision = new EvaluateDivision();
        double[] doubles = evaluateDivision.calcEquation(equations, ans, queries);
        System.out.println(doubles);
    }
}

