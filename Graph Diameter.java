Graph Diameter
Difficulty: MediumAccuracy: 69.56%Submissions: 9K+Points: 4
You are given an undirected connected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertex u and vertex v.
Find the diameter of the graph.
The diameter of a graph (sometimes called the width) is the number of edges on the longest path between two vertices in the graph.

Note: Graph do not contains any cycle.

Examples :

Input: V = 6, E = 5, edges[][] = [[0, 1], [0, 4], [1, 3], [1, 2], [2, 5]]
    
Output: 4
Explanation: The longest path in the graph is from vertices 4 to vertices 5 (4 -> 0 -> 1 -> 2 -> 5).
Input: V = 7, E = 6, edges[][] = [[0, 2], [0, 4], [0, 3], [3, 1], [3, 5], [1, 6]]
    
Output: 4
Explanation: The longest path in the graph is from vertices 2 to vertices 6 (2 -> 0 -> 3 -> 1 -> 6).
Constraints:
2 ≤ V ≤  105
1 ≤ E ≤  V - 1
0 ≤ edges[i][0], edges[i][1] < Vclass Solution {
    public void farthestNode(int curr, ArrayList<ArrayList<Integer>> adj,
                             int currentDist, int[] dist, boolean[] visited) {
        if (visited[curr]) return;
        if (dist[0] < currentDist) {

            dist[0] = currentDist;
            dist[1] = curr;
        }
        visited[curr] = true;
        for (int next : adj.get(curr)) {
            if (!visited[next]) {
                farthestNode(next, adj, currentDist + 1, dist, visited);
            }
        }
    }

    public int diameter(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int n = adj.size();
        int[] dist = new int[2];
        farthestNode(0, adj, 0, dist, new boolean[n]);
        int end1 = dist[1];

        dist = new int[2];

        farthestNode(end1, adj, 0, dist, new boolean[n]);
        return dist[0];
    }
}
