class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder str=new StringBuilder();
        int opencount=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                opencount++;
            }
            else if(ch==')'){
                if(opencount>0)
                opencount--;
                else
                continue;
            }
            str.append(ch);
        }
        StringBuilder result= new StringBuilder();
        int closecount=0;

        for(int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);

            if(ch==')')
            closecount++;

            else if(ch=='('){
                if(closecount>0)
                closecount--;

                else
                continue;
            }
            result.append(ch);
        }
        return result.reverse().toString();
    }
}