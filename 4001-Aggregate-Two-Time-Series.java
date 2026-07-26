class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>>result=new ArrayList<>();
        int i=0;
        int j=0;
        int n=series1.length, m=series2.length;

        while(i<n && j<m){
            if(series1[i][0]<series2[j][0]){
                result.add(Arrays.asList(series1[i][0],series1[i][1]+series2[j][1]));
                i++;
            }
            else if(series1[i][0]>series2[j][0]){
                result.add(Arrays.asList(series2[j][0],series1[i][1]+series2[j][1]));
                j++;
            }
            else if(series1[i][0]==series2[j][0]){
                result.add(Arrays.asList(series1[i][0],series1[i][1]+series2[j][1]));
                i++;
                j++;
            }
        }
        while(i<n){
            result.add(Arrays.asList(series1[i][0],series1[i][1]));
            i++;
        }
        while(j<m){
            result.add(Arrays.asList(series2[j][0],series2[j][1]));
            j++;
        }
        return result;

    }
}