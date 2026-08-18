class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;

        HashMap<Integer,Integer>freq=new HashMap<>();
        int max_element=Integer.MIN_VALUE;
        int max_first=-1;
        for(int num: nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
            max_element=Math.max(max_element,num);
        }
        for(int key : freq.keySet()){
            if(freq.get(key)==1)
            max_first=Math.max(max_first,key);
            
        }
        // if k==n, return the maximum element in the array
        if(k==n){
            return max_element;
        }
        // if k==1, return the largest element whose frequency is exactly 1
        if(k==1){
            return max_first;
        }

        // for 1<k<n, consider only nums[0] & nums[1]

        // if both are equal, then return -1
        if(nums[0]==nums[n-1]){
            return -1;
        }

        // if both occur exactly once, return their maximum
        if(freq.get(nums[0])==1 && freq.get(nums[n-1])==1){
            return Math.max(nums[0],nums[n-1]);
        }
        // if first element occurs exactly once, return first element
        if(freq.get(nums[0])==1 && freq.get(nums[n-1])!=1){
            return nums[0];
        }
        // if second element occurs exactly once, return second element
        if(freq.get(nums[0])!=1 && freq.get(nums[n-1])==1){
            return nums[n-1];
        }
        return -1;
    }
}