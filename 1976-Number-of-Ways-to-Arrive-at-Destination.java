class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<long[]>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            int w=road[2];

            adj.get(u).add(new long[]{v,w});
            adj.get(v).add(new long[]{u,w});
        }

        long dist[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);

        long ways[]=new long[n];
        dist[0]=0;
        ways[0]=1;

        PriorityQueue<long[]>pq=new PriorityQueue<>((a,b)-> Long.compare(a[0],b[0]));
        pq.add(new long[]{0,0});
        

        while(!pq.isEmpty()){
            long curr[]=pq.poll();

            long currdist=curr[0];
            int node=(int) curr[1];

            if(currdist>dist[node])
            continue;

            for(long neighbour[]: adj.get(node)){
                int nextnode=(int)neighbour[0];
                long nextdist=neighbour[1];

                long newdist=currdist+ nextdist;

                // found a new shorter path
                if(newdist < dist[nextnode]){
                    dist[nextnode]=newdist;
                    pq.add(new long[]{newdist,nextnode});
                    ways[nextnode]=ways[node];
                }
                // found another same shortest path
                else if(newdist == dist[nextnode]){
                    ways[nextnode]= (ways[nextnode]+ways[node]) % 1000000007;
                }

            }
        }
        return (int)ways[n-1];
    }
}