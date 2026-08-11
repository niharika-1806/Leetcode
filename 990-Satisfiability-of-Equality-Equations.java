class Solution {
    int parent[];
    int size[];
    public int find(int n){
        if(parent[n]==n)
        return n;

        parent[n]=find(parent[n]);
        return parent[n];
    }

    public void union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);

        if(rootA==rootB)
        return;

        if(size[rootA]< size[rootB]){
            parent[rootA]=rootB;
            size[rootB]+=size[rootA];
        }
        else{
            parent[rootB]=rootA;
            size[rootA]+=size[rootB];
        }
    }
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        size=new int[26];

        for(int i=0;i<26;i++){
            parent[i]=i;
            size[i]=1;
        }

        // first process '=='
        for(String equation: equations){
            if(equation.charAt(1)=='='){
                int a=equation.charAt(0) -'a';
                int b=equation.charAt(3) -'a';

                union(a,b);
            }
        }
        // process '!='
        for(String equation: equations){
            if(equation.charAt(1)=='!'){
                int a=equation.charAt(0)-'a';
                int b=equation.charAt(3)-'a';

                if(find(a)==find(b)){
                    return false;
                }
            }
        }
        return true;
    }
}