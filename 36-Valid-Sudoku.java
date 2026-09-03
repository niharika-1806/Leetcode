class Solution {
    public boolean isValidSudoku(char[][] board) {
        // creates an array of size 9 that can hold references to hashset objects
        HashSet<Character>rows[]=new HashSet[9];
        HashSet<Character>cols[]=new HashSet[9];
        HashSet<Character>box[]=new HashSet[9];

        for(int i=0;i<9;i++){
            rows[i]=new HashSet<>();
            cols[i]=new HashSet<>();
            box[i]=new HashSet<>();
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num=board[i][j];
                int k=(i/3)*3 + (j/3);

                if(num!='.'){
                    if(rows[i].contains(num)|| cols[j].contains(num)|| box[k].contains(num))
                        return false;

                    rows[i].add(num);
                    cols[j].add(num);
                    box[k].add(num);
                }
            }
        }
        return true;
    }
}