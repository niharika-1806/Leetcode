class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n=s.length();
        int freq[]=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }

        StringBuilder str=new StringBuilder();
        boolean found=false;

        for(int i=0;i<n;i++){
            char ch=target.charAt(i);
            int idx=ch-'a';

            // find the smallest character that is greater than equal to target[i]
            int curr=idx;
            while(curr<26 && freq[curr]==0){
                curr++;
            }
            // if no character available that is greater than equal to target[i],then backtrack
            if(curr==26)
            break;

            // else use the character
            freq[curr]--;
            str.append((char)(curr+'a'));

            // if curr>idx , then this is the first position where ans becomes greater than target
            if(curr>idx){
                found=true;
                break;
            }
        }
        // we didn't find any character greater than target[i], now backtrack
        if(!found){
            int i=str.length()-1;
            while(i>=0){
                // put the character we used at position i back into freq array
                int idx=str.charAt(i)-'a';
                freq[idx]++;

                // remove from the answer
                str.deleteCharAt(i);

                // now try to put the character strictly greater than the character that was at that position
                for(int j=idx+1;j<26;j++){
                    if(freq[j]>0){
                        // we found the smallest possible character greater than target[i]
                        str.append((char)(j+'a'));
                        freq[j]--;

                        found=true;
                        break;
                    }
                }
                // we found the position from where we will put rest of the remaining characters now
                if(found)
                break;
                // otherwise continue backtracking
                i--;
            }
            // we reached the beginning and couldn't make the answer greater than target
            if(!found)
            return "";
        }
        for(int i=0;i<26;i++){
            while(freq[i]>0){
                str.append((char)(i+'a'));
                freq[i]--;
            }
        }
        return str.toString();

    }
}