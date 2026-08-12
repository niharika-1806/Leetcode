class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        int j=0;
        HashMap<Integer,Integer>freq=new HashMap<>();
        int maxlength=Integer.MIN_VALUE;
        while(j<n){
            freq.put(nums[j],freq.getOrDefault(nums[j],0)+1);
            while(freq.get(nums[j])>k){
                freq.put(nums[i],freq.get(nums[i])-1);
                i++;
            }
            maxlength=Math.max(maxlength,j-i+1);
            j++;
        }
        return maxlength;
    }
}