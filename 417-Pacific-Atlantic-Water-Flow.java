class Solution {
    int m;
    int n;
    List<List<Integer>>result= new ArrayList<>();
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    public void dfs1(int row,int col,boolean [][]pacific,int [][]heights){
        if(row<0 || col<0 || row>=m || col>=n || pacific[row][col] )
        return;

        pacific[row][col]=true;
        for(int i=0;i<4;i++){
            int newrow=row+dx[i];
            int newcol=col+dy[i];

            if(newrow>=0 && newcol>=0 && newrow<m && newcol<n &&
            heights[newrow][newcol]>=heights[row][col])
            dfs1(newrow,newcol,pacific,heights);
        }

    }
     public void dfs2(int row,int col,boolean [][]atlantic,int [][]heights){
        if(row<0 || col<0 || row>=m || col>=n || atlantic[row][col] )
        return;

        atlantic[row][col]=true;
        for(int i=0;i<4;i++){
            int newrow=row+dx[i];
            int newcol=col+dy[i];

            if(newrow>=0 && newcol>=0 && newrow<m && newcol<n &&
            heights[newrow][newcol]>=heights[row][col])
            dfs2(newrow,newcol,atlantic,heights);
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m=heights.length;
        n=heights[0].length;

        boolean pacific[][]=new boolean[m][n];
        boolean atlantic[][]=new boolean[m][n];

        // check for pacific boundary

        // left boundary
        for(int i=0;i<m;i++){
            dfs1(i,0,pacific,heights);
        }

        // top boundary
        for(int j=0;j<n;j++){
            dfs1(0,j,pacific,heights);
        }

        // check for atlantic boundary
        // right boundary
        for(int i=0;i<m;i++){
            dfs2(i,n-1,atlantic,heights);
        }
        // bottom boundary
        for(int j=0;j<n;j++){
            dfs2(m-1,j,atlantic,heights);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
}