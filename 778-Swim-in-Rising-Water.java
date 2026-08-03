class Solution {
    public int swimInWater(int[][] grid) {
        int dx[]={-1,1,0,0};
        int dy[]={0,0,-1,1};

        int m=grid.length;
        int n=grid[0].length;

        int dist[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=grid[0][0];

        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        // distance,row,col
        pq.add(new int[]{grid[0][0],0,0});

        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int time=curr[0];
            int row=curr[1];
            int col=curr[2];

            if(time>dist[row][col])
            continue;

            if(row==m-1 && col==n-1)
            return time;

            for(int i=0;i<4;i++){
                int newrow=row+dx[i];
                int newcol=col+dy[i];

                if(newrow<0 || newcol<0 || newrow>=m || newcol>=n)
                continue;

               
                int newdistance= Math.max(time, grid[newrow][newcol]);

                if(newdistance< dist[newrow][newcol]){
                    dist[newrow][newcol]=newdistance;
                    pq.add(new int[]{newdistance,newrow,newcol});

                }
            }
        }
        return 0;
    }
}