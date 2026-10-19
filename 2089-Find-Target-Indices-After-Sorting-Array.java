class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer>result=new ArrayList<>();
        int countnum=0;
        int countequal=0;
        for(int num: nums){
            if(num<target)
            countnum++;

            else if(num==target)
            countequal++;
        }
        
        for(int i=countnum;i<countnum+countequal;i++){
            result.add(i);
        }
        return result;
    }
    
}