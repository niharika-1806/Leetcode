class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans=0;
        for(int i=0;i<32;i++){
            int count1=0;
            int count0=0;

            for(int j=0;j<nums.length;j++){
                if(((nums[j] >>i)&1)==1)
                count1++;
                else
                count0++;
            }
            ans+= (count1*count0);
       }
       return ans;
    }
}