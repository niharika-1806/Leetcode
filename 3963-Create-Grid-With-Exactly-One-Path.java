class Solution {
    public String[] createGrid(int m, int n) {
        String []result=new String[m];
        for(int i=0;i<m;i++){
            StringBuilder ans=new StringBuilder();
            for(int j=0;j<n;j++){
                if(i==0 || j==n-1)
                ans.append('.');

                else
                ans.append('#');
            }
            result[i]=ans.toString();
        }
        return result;
    }
}