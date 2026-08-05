class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>>adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }   
        for(int flight[]: flights){
            int u=flight[0];
            int v=flight[1];
            int price=flight[2];

            adj.get(u).add(new int []{v,price});
        }
        // storing cost of reaching every node
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        Queue<int[]>q=new LinkedList<>();
        // stops,node,cost
        q.add(new int[]{0,src,0});

        while(!q.isEmpty()){
            int curr[]=q.poll();
            int stops=curr[0];
            int node=curr[1];
            int cost=curr[2];

            if(stops>k)
            continue;

            for(int []neighbour: adj.get(node)){
                int nextnode=neighbour[0];
                int price=neighbour[1];

                int newprice=price+cost;

                if(newprice<dist[nextnode]){
                    dist[nextnode]=newprice;
                    q.add(new int[]{stops+1,nextnode,newprice});
                }

            }
        }
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}