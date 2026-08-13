class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int max=days[days.length-1];
        int dp[]=new int[max+1];
        for(int day: days){
            dp[day]=-1;
        }

        for(int i=1;i<=max;i++){
            if(dp[i]!=-1){
                dp[i]=dp[i-1];
            }
            else{
                int oneday=dp[i-1] + costs[0];
                int sevenday=dp[Math.max(0,i-7)]+ costs[1];
                int thirtyday=dp[Math.max(0,i-30)] + costs[2];

                dp[i]=Math.min(oneday,Math.min(sevenday,thirtyday));
            }
        }
        return dp[max];
    }
} 