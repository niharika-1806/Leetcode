class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer>freq=new HashMap<>();
        Integer []arr=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            arr[i]=nums[i];
        }

        Arrays.sort(arr,(a,b) ->
        {
            // if frequencies are not same, sort by frequencies
            if(freq.get(a)!= freq.get(b)){
                return freq.get(a) - freq.get(b);
            }
            // if frequencies are equal, then sorting criteria changes to the value
            return b-a;
        });
        for(int i=0;i<arr.length;i++){
            nums[i]=arr[i];
        }
        return nums;
    }
}