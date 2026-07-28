class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
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
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count++;

            for(int v: adj.get(node)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        // check if all courses are completed
        return count==numCourses;
    }

}