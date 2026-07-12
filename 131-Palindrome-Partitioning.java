class Solution {
    public boolean ispallindrome(String str){
        int left=0;
        int right=str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public void solve(int start, String s,List<String>current, List<List<String>>result){
        if(start==s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<s.length();i++){
            String str=s.substring(start,i+1);

            if(!ispallindrome(str)){
                continue;
            }
            current.add(str);
            solve(i+1,s,current,result);
            current.remove(current.size()-1);
        }
        
    }
    public List<List<String>> partition(String s) {
        List<List<String>>result=new ArrayList<>();
        List<String>current=new ArrayList<>();
        solve(0,s,current,result);
        return result;
    }
}