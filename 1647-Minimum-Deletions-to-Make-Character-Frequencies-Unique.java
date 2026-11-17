class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer>freq=new HashMap<>();
        for(char ch: s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        HashSet<Integer>set=new HashSet<>();
        int deletions=0;
        for(int freqs: freq.values()){
            while(freqs>0 && set.contains(freqs)){
                freqs--;
                deletions++;
            }
            set.add(freqs);
        }
        return deletions;
    }
    
}