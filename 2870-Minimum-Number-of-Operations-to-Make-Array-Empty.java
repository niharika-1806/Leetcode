class Solution {
    public int minOperations(int[] nums) {
        int ops=0;
        HashMap<Integer,Integer>freq=new HashMap<>();
        for(int n: nums){
            freq.put(n,freq.getOrDefault(n,0)+1);
        }
        for(int f: freq.values()){
           if(f==1)
           return -1;

           else if(f%3==0)
           ops+=f/3;
           
           else if(f%3==1 || f%3==2)
           ops+= (f/3)+1;
        
        }
        return ops;
    }
}