class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer>st=new Stack<>();
        int ans[]=new int[nums.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<2*n;i++){
            int num=nums[i%n];
            while(!st.isEmpty() && nums[st.peek()]<num){
                ans[st.pop()]=num;
            }
            if(i<n)
            st.push(i);
        }
        return ans;
    }
}