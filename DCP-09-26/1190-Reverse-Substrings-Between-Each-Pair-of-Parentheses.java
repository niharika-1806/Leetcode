class Solution {
    public String reverseParentheses(String s) {
        Stack<String>st=new Stack<>();
        StringBuilder ans=new StringBuilder();
        char chars[]=s.toCharArray();

        for(char ch:chars){
            if(ch=='('){
                // push the current string
                st.push(ans.toString());
                // reset the ans to empty for storing another strings
                ans.setLength(0);
            }
            else if(ch==')'){
                // reverse the current string
                ans.reverse();
                // pop the the top of the stack and concatenate it with the reversed substring
                ans.insert(0,st.pop());
            }
            else{
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}