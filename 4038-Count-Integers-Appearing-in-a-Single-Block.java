class Solution {
    public int countSpecialIntegers(int[] nums) {
        int ans=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(i==0 ||nums[i]!=nums[i-1] ){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        for(int count: map.values()){
            if(count==1){
                ans++;
            }
        }
        return ans;
    }
}