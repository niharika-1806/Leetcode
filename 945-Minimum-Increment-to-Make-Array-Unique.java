class Solution {
    public int minIncrementForUnique(int[] nums) {
        int moves=0;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                int newval= nums[i-1]+1;
                moves+= (newval-nums[i]);
                nums[i]=newval;
            }
        }
        return moves;
    }
}