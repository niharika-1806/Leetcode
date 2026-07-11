class Solution {
    public void solve(int start,String s,List<String>current, List<String>result){
        // if we made 4 segmetns and covered all the characters of string, add into the result
        if(current.size()==4){
            if(start==s.length()){
                result.add(String.join(".",current));
            }
            return;
        }
        // try segments of length 1,2,3 only
        for(int i=start;i<start+3 && i<s.length();i++){
            // starting from start ending till i, 
            String segment=s.substring(start,i+1);

            // if leading zeros are there, start from next index
            if(segment.length()>1 && segment.charAt(0)=='0'){
                continue;
            }
            int val=Integer.parseInt(segment);

            // if value is greater than 255, invalid, start from next index
            if(val>255){
                continue;
            }
            // include
            current.add(segment);
            // explore
            solve(i+1,s,current,result);
            // remove
            current.remove(current.size()-1);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String>result= new ArrayList<>();
        List<String>current=new ArrayList<>();
        solve(0,s,current,result);
        return result;
    }
}