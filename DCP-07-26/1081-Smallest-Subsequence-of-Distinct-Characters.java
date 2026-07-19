class Solution {
    public String smallestSubsequence(String s) {
        int last[]=new int[26];
        boolean []visited=new boolean[26];

        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            // if character is already in stack,ignore
            if(visited[ch-'a'])
            continue;
            // if stack is not empty and the current character is smaller(better result) and if we will see it later,pop from the stack
            while(!st.isEmpty() && st.peek()>ch && last[st.peek()-'a']>i){
                visited[st.pop()-'a']=false;
            }
            st.push(ch);
            visited[ch-'a']=true;

        }
        StringBuilder result=new StringBuilder();
        for(char ch:st){
            result.append(ch);
        }
        return result.toString();
    }
}