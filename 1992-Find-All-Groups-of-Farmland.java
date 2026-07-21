class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    int bottomrow=0;
    int rightcol=0;

    public void dfs(int row,int col, int [][]land,
    boolean [][]visited){
        if(row<0 || col<0 || row>=m || col>=n || visited[row][col] || 
        land[row][col]==0){
            return;
        }
        visited[row][col]=true;

        bottomrow=Math.max(bottomrow,row);
        rightcol=Math.max(rightcol,col);

        for(int i=0;i<4;i++){
            int newrow=row+dx[i];
            int newcol=col+dy[i];
            dfs(newrow,newcol,land,visited);
        }
    }
    public int[][] findFarmland(int[][] land) {
        m=land.length;
        n=land[0].length;

        List<int[]>result=new ArrayList<>();

        boolean [][]visited=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(land[i][j]==1 && !visited[i][j]){
                    bottomrow=i;
                    rightcol=j;
                    dfs(i,j,land,visited);
                    result.add(new int []{i,j,bottomrow,rightcol});
                }
            }
        }
        return result.toArray(new int[result.size()][]);
        
    }
}