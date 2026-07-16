class Solution {
    public int calcgcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int maxi=nums[0];

        int prefixgcd[]=new int[n];
        prefixgcd[0]=nums[0];
        for(int i=1;i<n;i++){
            maxi=Math.max(maxi,nums[i]);
            int gcd=calcgcd(nums[i],maxi);
            prefixgcd[i]=gcd;
        }
        Arrays.sort(prefixgcd);
        int i=0;
        int j=n-1;
        long sum=0;
        while(i<j){
            sum+=calcgcd(prefixgcd[i],prefixgcd[j]);
            i++;
            j--;
        }
        return sum;
    
    }
}