class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        Stack<Integer>st=new Stack<>();

        for(int i=0;i<n;i++){
            //push those indices that can be valid starting points
            if(st.isEmpty() || nums[i]<nums[st.peek()])
            st.push(i);
        }
        int maxwidth=0;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                maxwidth=Math.max(maxwidth,i-st.peek());
                st.pop();
            }
        }
        return maxwidth;
    }
}