class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        st.push(0);
        int score=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(0);
            }
            // if current ch is ')'
            else{
                // store the previous score
                int store=st.pop();
                // if it is 0, means nothing is inside it , and it is '()', so score is 1
                if(store==0){
                    score=1;
                }
                // if it is > 0, means something is inside it, so score is 2*(A)
                else{
                    score=2*store;
                }
                // add recent score
                int top=st.pop();
                st.push(top+score);
                
            }
        }
        return st.peek();
    }
}