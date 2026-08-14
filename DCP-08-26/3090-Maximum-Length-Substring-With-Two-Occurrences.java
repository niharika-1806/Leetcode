class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer>freq=new HashMap<>();
        int i=0,j=0;
        int maxlength=Integer.MIN_VALUE;
        while(j<s.length()){
            freq.put(s.charAt(j),freq.getOrDefault(s.charAt(j),0)+1);
            while(freq.get(s.charAt(j))>2){
                freq.put(s.charAt(i),freq.get(s.charAt(i))-1);
                i++;
            }
            maxlength=Math.max(maxlength,j-i+1);
            j++;
        }
        return maxlength;
    }
}