class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer>st=new Stack<>();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            int digit=ch-'0';
            while(!st.isEmpty() && st.peek()>digit && k>0){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }

        while(!st.isEmpty()){
            str.append(st.pop());
        }
        str.reverse();
        int i=0;
        while(i<str.length() && str.charAt(i)=='0')
        i++;

        String ans=str.substring(i);

        return ans.isEmpty() ? "0" : ans;

    }
}