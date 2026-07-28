class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer>ans=new ArrayList<>();
        List<List<Integer>>adj=new ArrayList<>();
        int outdegree[]=new int[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            outdegree[i]=graph[i].length;

            for(int v: graph[i]){
                adj.get(v).add(i);
            }
        }
        for(int i=0;i<n;i++){
            if(outdegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int v: adj.get(node)){
                outdegree[v]--;
                if(outdegree[v]==0){
                    q.add(v);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}