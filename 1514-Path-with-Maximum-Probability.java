class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double []>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double w=succProb[i];

            adj.get(u).add(new double[]{v,w});
            adj.get(v).add(new double[]{u,w});
        }
        double dist[]=new double[n+1];
        Arrays.fill(dist,0.0);
        // probability of reaching start node is 1 because we're already there.
        dist[start_node]=1.0;

        PriorityQueue<double []>pq=new PriorityQueue<>((a,b)-> Double.compare(b[0],a[0]));
        pq.add(new double[]{1.0,start_node});

        while(!pq.isEmpty()){
            double []curr=pq.poll();
            double currprob=curr[0];
            int node=(int)curr[1];

            if(node==end_node)
            return currprob;

            if(currprob< dist[node])
            continue;

            for(double[]neighbour : adj.get(node)){
                int nextnode=(int)neighbour[0];
                double edgeprob=neighbour[1];

                double newprob=currprob*edgeprob;

                if(newprob>dist[nextnode]){
                    dist[nextnode]=newprob;
                    pq.add(new double[]{newprob,nextnode});
                }

            }
        }
        return 0;

    }
}