class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                // checking if the ith bit is 1
                if(((nums[j]>>i)&1)==1){
                    count++;
                    count%=3;
                }
            }
            // reforming the answer bit by bit
            if(count!=0){
                ans= (ans | (1<<i));
            }
        }
        return ans;
    }
}