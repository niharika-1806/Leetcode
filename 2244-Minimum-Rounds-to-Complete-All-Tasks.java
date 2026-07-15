class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer>freq=new HashMap<>();
        for(int t: tasks){
            freq.put(t,freq.getOrDefault(t,0)+1);
        }
        int round=0;
        for(int f: freq.values()){
            if(f==1)
            return -1;
            if(f%3==0){
                round+= f/3;
            }
            else if(f%3==1 || f%3==2){
                round+= f/3 + 1;
            }
        }
        return round;
    }
}