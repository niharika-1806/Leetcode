class Solution {
    public long calc(int candies[], int candy){
        long children=0;
        for(int i=0;i<candies.length;i++){
            children+= (candies[i]/candy);
        }
        return children;
    }
    public int maximumCandies(int[] candies, long k) {
        int maxi=Integer.MIN_VALUE;
        for(int can: candies){
            maxi=Math.max(maxi,can);
        }
        int low=1, high=maxi;
        int ans=0;
        while(low<=high){
            int candy=low+(high-low)/2;
            long children=calc(candies,candy);

            if(children>=k){
                ans=candy;
                low=candy+1;
            }
            else{
                high=candy-1;
            }
        }
        return ans;
    }
}