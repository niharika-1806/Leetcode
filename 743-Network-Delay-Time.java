class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>>adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int time[]: times){
            int u=time[0];
            int v=time[1];
            int w=time[2];

            adj.get(u).add(new int[]{v,w});
        }
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]>pq=new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0],b[0])
        );
        dist[k]=0;
        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int distance=curr[0];
            int node=curr[1];

            if(distance> dist[node])
            continue;

            for(int neighbours[]: adj.get(node)){
                int neighbour=neighbours[0];
                int weight=neighbours[1];

                if(distance+weight< dist[neighbour]){
                    dist[neighbour]=distance+weight;
                    pq.offer(new int[]{dist[neighbour],neighbour});
                }
            }
        }
        int maxdist=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)
            return -1;

            maxdist=Math.max(maxdist,dist[i]);
        }
        return maxdist;

    }
}