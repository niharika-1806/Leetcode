class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    int ans=0;

    HashMap<Integer,Integer>size=new HashMap<>();

    public void dfs(int row,int col, int [][]grid,int change){
        if(row<0 || col<0 || row>=m || col>=n || grid[row][col]!=1)
        return;

        grid[row][col]=change;

        size.put(change,size.getOrDefault(change,0)+1);
        for(int i=0;i<4;i++){
            int newrow=row+dx[i];
            int newcol=col+dy[i];
            dfs(newrow,newcol,grid,change);
        }
    }
    public int largestIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int change=2;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(i,j,grid,change);
                    change++;
                }
            }
        }
        int ans=0;
        // if the grid is all 1's
        for(int s: size.values()){
            ans=Math.max(ans,s);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    // if the neighbours of 0 belong to same island, store only 1 neighbour, so we want unique island id's
                    HashSet<Integer>set=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int newrow=i+dx[k];
                        int newcol=j+dy[k];

                        if(newrow<0 || newcol<0 || newrow>=m || newcol>=n )
                        continue;

                        if(grid[newrow][newcol]>1)
                        set.add(grid[newrow][newcol]);
                    }
                    int current=1; // adding 1 for the 0 itself
                    for(int s: set){
                        current+= (size.get(s)); //get the size from hashmap
                    }
                    ans=Math.max(ans,current);
                }
            }
        }
        return ans;
    }
}