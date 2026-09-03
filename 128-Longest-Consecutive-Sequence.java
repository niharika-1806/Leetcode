class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int len=0;
        for(int num: set){
            // if num-1 doesn't exist , then this is the start of the sequence
            if(!set.contains(num-1)){
                int curr=num;
                int currlen=1;

                while(set.contains(curr+1)){
                    curr++;
                    currlen++;
                }
                len=Math.max(len,currlen);
            }
        }
        return len;
    }
}