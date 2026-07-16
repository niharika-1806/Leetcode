class Solution {
    public long minimumSteps(String s) {
        long ans=0;
        long one=0;
        for(char ch : s.toCharArray()){
            if(ch=='1'){
                one++;
            }
            else{
                ans+=one;
            }
        }
        return ans;
    }
}