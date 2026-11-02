class Solution {
    public long calc(int []piles, int speed){
        long hours=0;
        for(int pile:piles){
            hours+= ((pile+speed-1)/speed);
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int maxi=Integer.MIN_VALUE;

        for(int pile:piles){
            maxi=Math.max(maxi,pile);
        }
        int low=1;
        int high=maxi;
        int ans=0;

        while(low<=high){
            int speed=low+(high-low)/2;
            long hrs=calc(piles,speed);

            if(hrs<=h){
                ans=speed;
                high=speed-1;
            }
            else{
                low=speed+1;
            }
        }
        return ans;
    }
}