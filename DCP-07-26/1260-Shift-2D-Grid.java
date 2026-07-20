class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;

        k=k%(m*n);
        while(k-->0){
            int [][]temp= new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    // (0,0) 
                    if(i==0 && j==0){
                        temp[i][j]=grid[m-1][n-1];
                    }
                    // first column
                    else if(j==0){
                        temp[i][0]=grid[i-1][n-1];
                    }
                    // normal element
                    else{
                        temp[i][j]=grid[i][j-1];
                    }
                }
            }
            grid=temp;
        }
        List<List<Integer>>result=new ArrayList<>();
        for(int i=0;i<m;i++){
            List<Integer>row=new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(grid[i][j]);
            }
            result.add(row);
        }
        return result;
    }
}