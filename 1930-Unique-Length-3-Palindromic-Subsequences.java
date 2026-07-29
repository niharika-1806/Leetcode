class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans=0;
        int first[]=new int[26];
        int last[]=new int[26];

        Arrays.fill(first,-1);
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(first[idx]==-1){
                first[idx]=i;
            }
            last[idx]=i;
        }
        // process each character as outer character
        for(int i=0;i<26;i++){
            // if character never appeared or there is not even one character between first and last
            if(first[i]==-1 || last[i]-first[i]<2)
            continue;

            HashSet<Character>set=new HashSet<>();
            for(int j=first[i]+1;j<last[i];j++){
                set.add(s.charAt(j));
            }
            ans+=set.size();
        }
        return ans;
    }
}