class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;

        // we can already make the low score 0, by changing both the elements to a same number
        // now the task is to minimize high score as (maximum element - minimum element)
        int case1=nums[n-1]-nums[2];
        int case2=nums[n-2]-nums[1];
        int case3=nums[n-3]-nums[0];

        return Math.min(case1,Math.min(case2,case3));
    }
}