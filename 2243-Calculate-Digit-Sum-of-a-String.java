class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder str=new StringBuilder();
            for(int i=0;i<s.length();i+=k){
                int sum=0;
                int j=i;
                while(j<s.length() && j<i+k){
                    sum+=s.charAt(j)-'0';
                    j++;
                }
                str.append(sum);
            }
            s=str.toString();
        }
        return s;
    }
}