class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    
    boolean island=false;

    public void dfs(int row,int col,boolean [][]visited, int [][]grid1, int [][]grid2){
        visited[row][col]=true;

        if(grid1[row][col]==0)
        island=false;

        for(int i=0;i<4;i++){
            int newrow=row+dx[i];
            int newcol=col+dy[i];

            if(newrow>=0 && newcol>=0 && newrow<m && newcol<n && !visited[newrow][newcol] && grid2[newrow][newcol]==1)
            dfs(newrow,newcol,visited,grid1,grid2);
        }
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m=grid1.length;
        n=grid1[0].length;

        boolean[][]visited=new boolean[m][n];

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1 && !visited[i][j]){
                    // if a new island found, then check if it matches with grid1 or not
                    island=true;
                    dfs(i,j,visited,grid1,grid2);

                    // if it is matching with grid1 and it is still true, increase the count 
                    if(island)
                    count++;
                }
            }
        }
        return count;
        
    }
}