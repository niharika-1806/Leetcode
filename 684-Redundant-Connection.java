class Solution {
    int parent[];
    int size[];
    int find(int n){
        if(parent[n]==n)
        return n;

        parent[n]=find(parent[n]);
        return parent[n];
    }

    void union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);

        // already same components
        if(rootA==rootB)
        return;

        if(size[rootA]<size[rootB]){
            parent[rootB]=rootA;
            size[rootA]+=size[rootB];
        }
        else{
            parent[rootA]=rootB;
            size[rootB]+=size[rootA];
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        
        parent= new int[n+1];
        size=new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int edge[]: edges){
            int u=edge[0];
            int v=edge[1];

            // if they have the same parent before union, means another edge is connected them, return the edge that is making a cycle
            if(find(u)==find(v)){
                return edge;
            }
            union(u,v);
        }
        return new int[0];
    }
}