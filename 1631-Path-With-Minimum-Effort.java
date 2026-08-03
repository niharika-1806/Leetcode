class Solution {
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;

        int dist[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=0;

        PriorityQueue<int []>pq=new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        // effort,row,col
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int effort=curr[0];
            int row=curr[1];
            int col=curr[2];

            if(row==m-1 && col==n-1)
            return effort;

            for(int i=0;i<4;i++){
                int newrow=row+dx[i];
                int newcol=col+dy[i];

                if(newrow<0 || newcol<0 || newrow>=m || newcol>=n)
                continue;

                // difference between current and neighbour cell
                int diff=Math.abs(heights[row][col]- heights[newrow][newcol]);
                // Maximum effort in this path
                int neweffort=Math.max(effort,diff); 

                if(neweffort< dist[newrow][newcol]){
                    dist[newrow][newcol]=neweffort;
                    pq.add(new int[]{neweffort,newrow,newcol});
                }
            }

        }
        return 0;

    }
}