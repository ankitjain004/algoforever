/* 785 There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {
    int n;
    int[][] adj;
    int[] colorNode;
    public boolean isBipartite(int[][] graph) {
        n = graph.length;
        adj = new int[n][n];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adj[i][graph[i][j]]=1;
                adj[graph[i][j]][i]=1;
            }
        }


        colorNode = new int[n];
        Arrays.fill(colorNode, -1);

        for(int i=0;i<n;i++)
        {
            if(colorNode[i]==-1)
            {
                colorNode[i] = 0;
                if(color(i)==false)
                    return false;
            }
        }
        return true;
    }

    public boolean color(int node)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(node);

        while(!q.isEmpty())
        {
            int curr = q.poll();
            int color = colorNode[curr];
            for(int i=0;i<n;i++)
            {
                if(adj[curr][i]>0 && colorNode[i]!=-1 && colorNode[i]!= 1-colorNode[curr])
                {
                    return false;
                }
                else if(adj[curr][i]>0 && colorNode[i]==-1)
                {
                    q.add(i);
                    colorNode[i] = 1 - colorNode[curr];
                }
            }
        }

        return true;
    }
}