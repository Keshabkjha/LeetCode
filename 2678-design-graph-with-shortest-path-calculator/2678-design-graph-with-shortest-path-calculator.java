class Graph {
    int n;
    int[][] dists;
    boolean[] hasOut;
    static final int MAX = 10_000_000;

    public Graph(int n, int[][] edges) {
        // Initialize class values.
        this.n = n;
        dists = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            int[] nodeDists = dists[i];
            for (int j = n - 1; j >= 0; j--)  nodeDists[j] = MAX;
            nodeDists[i] = 0;
        }
        hasOut = new boolean[n];

        // Build initial graph from passed edges.
        for (int[] edge : edges) {
            dists[edge[0]][edge[1]] = edge[2];
            hasOut[edge[0]] = true;
        }

        // Calculate and save the distances from every node to every other node.
        for (int newEdge = n - 1; newEdge >= 0; newEdge--) {
            if (!hasOut[newEdge])  continue;
            int[] newEdgesDists = dists[newEdge];
            for (int from = n - 1; from >= 0; from--) {
                if (!hasOut[from])  continue;
                int[] fromDists = dists[from];
                for (int to = n - 1; to >= 0; to--) 
                    fromDists[to] = Math.min(fromDists[to], 
                                    fromDists[newEdge] + newEdgesDists[to]);
            }
        }
    }
    
    public void addEdge(int[] edge) {
        if (dists[edge[0]][edge[1]] <= edge[2])  return;
        hasOut[edge[0]] = true;
        int newFrom = edge[0];
        int newTo = edge[1];
        int newDist = edge[2];
        dists[newFrom][newTo] = newDist;
        int[] newToDists = dists[newTo];
        
		// Update the pre-calculated distances from every node to every other node.
        for (int from = n - 1; from >= 0; from--) {
            if (!hasOut[from])  continue;
            int[] fromDists = dists[from];
            for (int to = n - 1; to >= 0; to--) 
                fromDists[to] = Math.min(fromDists[to], 
                                fromDists[newFrom] + newDist + newToDists[to]);
        }
    }
    
    public int shortestPath(int node1, int node2) {
        return (dists[node1][node2] == MAX) ? -1 : dists[node1][node2];
    }
}