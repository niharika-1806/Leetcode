class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
        int []ans=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int pre[]: prerequisites){
            int v=pre[0];
            int u=pre[1];

            adj.get(u).add(v);
        }
        Queue<Integer>q=new LinkedList<>();
        int indegree[]=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            for(int v: adj.get(i)){
                indegree[v]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int j=0;
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[j++]=node;
            count++;
            for(int v: adj.get(node)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        if(count!=numCourses)
        return new int[0];
        return ans;
    }
}