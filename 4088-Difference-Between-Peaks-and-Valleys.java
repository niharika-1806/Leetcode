class Solution {
    public int peakValleyDifference(int[] nums) {
        int peaksum=0;
        int valleysum=0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]<nums[i-1] && nums[i]<nums[i+1])
            valleysum+=nums[i];

            else if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
            peaksum+=nums[i];
        }
        return peaksum - valleysum;
    }
}