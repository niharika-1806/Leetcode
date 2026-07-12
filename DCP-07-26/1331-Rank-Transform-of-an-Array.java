class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int copy[]=new int[n];
        for(int i=0;i<n;i++){
            copy[i]=arr[i];
        }
        Arrays.sort(copy);
        int rank=1;
        for(int num: copy){
            if(!map.containsKey(num)){
                map.put(num,rank);
                rank++;
            }
        }
        for(int i=0;i<n;i++){
            copy[i]=map.get(arr[i]);
        }
        return copy;
    }
}