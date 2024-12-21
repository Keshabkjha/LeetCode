class Solution {
    private int res = 0;

    private int dfs(List<Integer>[] graph, int k, int[] values, int curr, int parent){
        int rem = values[curr] % k;

        for(int child : graph[curr]){
            if(child != parent){
                int child_rem = dfs(graph, k, values, child, curr);
                if(child_rem % k == 0){
                    res++;
                }
                else{
                    rem = (rem + child_rem) % k;
                }
            }
        }
        return rem;
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] graph = new List[n];

        for(int i = 0;i < n;i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int rem = dfs(graph, k, values, 0, -1);
        if(rem == 0){
            res++;
        }
        return res;
    }
}