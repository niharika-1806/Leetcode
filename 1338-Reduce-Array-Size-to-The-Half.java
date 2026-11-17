class Solution {
    public int minSetSize(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer>freq=new HashMap<>();
        for(int num: arr){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(
            (a,b)-> Integer.compare(b,a)
        );
        for(int freqs: freq.values()){
            pq.offer(freqs);
        }
        int count=0;
        int removed=0;
        while(removed<n/2){
            removed+=pq.poll();
            count++;
        }
        return count;

    }
}