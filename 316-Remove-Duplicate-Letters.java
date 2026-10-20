class Solution {
    public String removeDuplicateLetters(String s) {
        int last[]=new int[26];
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }
        Stack<Character>st=new Stack<>();
        boolean []visited=new boolean[26];

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(visited[ch-'a'])
            continue;

            while(!st.isEmpty() && st.peek()>ch && last[st.peek()-'a']>i){
                char c=st.pop();
                visited[c-'a']=false;
            }
            st.push(ch);
            visited[ch-'a']=true;
        }
        StringBuilder str=new StringBuilder();
        while(!st.isEmpty())
        str.append(st.pop());

        return str.reverse().toString();
    }
}