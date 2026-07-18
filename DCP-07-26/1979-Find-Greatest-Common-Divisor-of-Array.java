class Solution {
    public int findGCD(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        for(int n:nums){
            max=Math.max(n,max);
            min=Math.min(n,min);
        }

        while(min!=0){
            int temp=min;
            min=max%min;
            max=temp;
        }
        return max;
    }
}