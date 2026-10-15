class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            boolean destroyed=false;
            
            while(!st.isEmpty() && st.peek()>0 && arr[i]<0){
                if(st.peek()<(-arr[i])){
                    st.pop();
                    continue;
                }
                else if(st.peek()==(-arr[i])){
                    st.pop();
                    destroyed=true;
                    break;
                }
                else if(st.peek()>(-arr[i])){
                    destroyed=true;
                    break;
                }
            }
            if(!destroyed)
            st.push(arr[i]);
        }
        int ans[]=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}