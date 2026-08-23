class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        // storing indices
        Deque<Integer>dq=new ArrayDeque<>();
        int []result=new int[n-k+1];
        int x=0;
        for(int i=0;i<n;i++){
            // out of bounds
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            // if new element is greater, remove all other smaller elemnents(monotonic decreasing queue) 
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
            // window is started
            if(i>=k-1){
                result[x++]=nums[dq.peekFirst()];
            }
        }
        return result;
    }
}