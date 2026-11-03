class Solution {
    public int calc(int bloomDay[], int days, int k){
        int bouquets=0;
        int flowers=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=days){
                flowers++;
                if(flowers==k){
                    bouquets++;
                    flowers=0;
                }
            }
            else
            flowers=0;
        }
        return bouquets;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;

        for(int b: bloomDay){
            mini=Math.min(mini,b);
            maxi=Math.max(maxi,b);
        }
        int low=mini,high=maxi;
        int ans=-1;
        while(low<=high){
            int days=low+(high-low)/2;
            int bouquets=calc(bloomDay,days,k);

            if(bouquets>=m){
                ans=days;
                high=days-1;
            }
            else{
                low=days+1;
            }
        }
        return ans;
    }
}