/*You are given an undirected graph. You are given an integer n which is the number of nodes in the graph and an array edges,
where each edges[i] = [ui, vi] indicates that there is an undirected edge between ui and vi.

A connected trio is a set of three nodes where there is an edge between every pair of them.

The degree of a connected trio is the number of edges where one endpoint is in the trio, and the other is not.

Return the minimum degree of a connected trio in the graph, or -1 if the graph has no connected trios.*/


import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MinimumDegreeOfConnectedTrio {
    public int minTrioDegree(int n, int[][] edges) {
        int[] degree = new int[n+1];
        int[][] mat = new int[n+1][n+1];
        Map<Integer, List<Integer>> map = new HashMap();
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<edges.length;i++)
        {
            int a = edges[i][0];
            int b = edges[i][1];
            mat[a][b]=1;
            mat[b][a]=1;
            degree[a]++;
            degree[b]++;
        }

        for(int i=1;i<=n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {
                if(mat[i][j]==1)
                {
                    for(int k=j+1;k<=n;k++)
                    {
                        if(mat[j][k]==1 && mat[k][i]==1)
                        {
                            ans = Math.min(ans, degree[i]+degree[j]+degree[k]-6);
                        }
                    }
                }
            }
        }

        return ans==Integer.MAX_VALUE?-1:ans;
    }
}