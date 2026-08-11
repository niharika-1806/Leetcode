class Solution {
    public void dfs(int node, boolean []visited, int [][]stones){
        visited[node]=true;
        for(int i=0;i<stones.length;i++){
            if(!visited[i]){
                if(stones[node][0]==stones[i][0] || stones[node][1]==stones[i][1])
                dfs(i,visited,stones);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;

        boolean[]visited=new boolean[n];
        int components=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                components++;
                dfs(i,visited,stones);
            }
        }
        return n-components;
    }
}