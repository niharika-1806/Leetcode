class Solution {
    public int calc(int price[],int tastiness){
        int candies=1;
        int last=price[0];
        for(int i=1;i<price.length;i++){
            if(price[i]-last>=tastiness){
                candies++;
                last=price[i];
            }
        }
        return candies;

    }
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low=0,high=price[price.length-1]-price[0];

        int ans=low;

        while(low<=high){
            int tastiness=low+(high-low)/2;
            int candies=calc(price,tastiness);

            if(candies>=k){
                ans=tastiness;
                low=tastiness+1;
            }
            else{
                high=tastiness-1;
            }
        }
        return ans;
    }
}