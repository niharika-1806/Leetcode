class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer>freq=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!freq.containsKey(ch))
            return false;

            freq.put(ch,freq.get(ch)-1);
            if(freq.get(ch)==0)
            freq.remove(ch);
            
        }
        if(freq.size()==0)
        return true;

        return false;
    }
}