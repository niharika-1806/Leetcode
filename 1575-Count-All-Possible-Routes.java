class Solution {
    int dp[][];
    int n;
    int MOD=1_000_000_007;

    public int solve(int city, int fuel, int finish,int []locations){
        // if already calculated then return
        if(dp[city][fuel]!=-1)
        return dp[city][fuel];

        long ways=0;
        if(city==finish)
        ways=1;

        for(int j=0;j<n;j++){
            if(j==city)
            continue;

            int cost=Math.abs(locations[city]-locations[j]);
            if(cost<=fuel){
                ways+=solve(j,fuel-cost,finish,locations);
                ways%=MOD;
                
            }
        }
        // memoization
        return dp[city][fuel]= (int)ways;
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        n=locations.length;
        // number of routes from city i to finish with atmost f fuels.
        dp=new int[n][fuel+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(start,fuel,finish,locations);        
    }
}