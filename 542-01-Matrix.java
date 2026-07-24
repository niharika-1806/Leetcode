class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    public int[][] updateMatrix(int[][] mat) {
        m=mat.length;
        n=mat[0].length;
        int ans[][]=new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(ans[i],-1);
        }
        Deque<int []>q=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                    ans[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int []curr=q.poll();
                int row=curr[0];
                int col=curr[1];

                
                for(int j=0;j<4;j++){
                    int newrow=row+dx[j];
                    int newcol=col+dy[j];

                    if(newrow>=0 && newcol>=0 && newrow<m && newcol<n &&
                     ans[newrow][newcol]==-1){
                        ans[newrow][newcol]=ans[row][col]+1;
                        q.add(new int[]{newrow,newcol});
                    }
                }
            }
        }
        return ans;
    }
}