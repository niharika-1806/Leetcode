class Solution {
    public int calc(int []quantities, int products){
        int stores=0;
        for(int i=0;i<quantities.length;i++){
            stores+= (quantities[i]+products-1)/products;
        }
        return stores;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int m=quantities.length;
        int maxi=Integer.MIN_VALUE;

        for(int q: quantities){
            maxi=Math.max(maxi,q);
        }
        int low=1 , high=maxi;
        int ans=0;
        while(low<=high){
            int product=low+(high-low)/2;
            int stores= calc(quantities,product);

            if(stores<=n){
                ans=product;
                high=product-1;
            }
            else{
                low=product+1;
            }
        }
        return ans;


    }
}