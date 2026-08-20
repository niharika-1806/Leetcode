class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer>result=new ArrayList<>();
        HashMap<String,Integer>need=new HashMap<>();
        int wordlen=words[0].length();
        int totalwords=words.length;
        int totallen=wordlen*totalwords;

        if(s.length()<totallen)
        return result;

        for(String word: words){
            need.put(word,need.getOrDefault(word,0)+1);
        }
        
        // we've 0-wordlen-1 possible alignments
        for(int i=0;i<wordlen;i++){
            int left=i; //start of the window
            int right=i; // point from where we read the next word

            HashMap<String,Integer>window=new HashMap<>();
            int count=0;
            // move in the chunks of word.length
            while(right+wordlen<=s.length()){
                String word=s.substring(right,right+wordlen);
                right+=wordlen;

                // if we don't need this word, then clear the hashmap and start a new window, reset everything
                if(!need.containsKey(word)){
                    window.clear();
                    count=0;
                    left=right;
                    continue;
                }
                window.put(word,window.getOrDefault(word,0)+1);
                count++;

                // if the frequency of the words needed becomes large, try to shrink the window until frequency becomes valid again

                while(window.get(word)>need.get(word)){
                    String remword=s.substring(left,left+wordlen);
                    window.put(remword,window.getOrDefault(remword,0)-1);
                    left+=wordlen;
                    count--;
                }
                if(count==words.length){
                    result.add(left);
                }
            }
        }
        return result;
    }
}