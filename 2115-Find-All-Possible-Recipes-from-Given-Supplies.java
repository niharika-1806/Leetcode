class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, List<String>>adj=new HashMap<>();
        HashMap<String,Integer>indegree=new HashMap<>();
        
        for(int i=0;i<recipes.length;i++){
            String recipe= recipes[i];
            for(String ing: ingredients.get(i)){
                if(!adj.containsKey(ing)){
                    adj.put(ing, new ArrayList<>());
                }
                adj.get(ing).add(recipe);
           }
        }
        for(int i=0;i<recipes.length;i++){
            indegree.put(recipes[i],ingredients.get(i).size());
        }
        Queue<String>q=new LinkedList<>();
        for(String supply: supplies){
            q.add(supply);
        }
        List<String>ans=new ArrayList<>();
        while(!q.isEmpty()){
            String item=q.poll();
            // is any recipe waiting for this item, if no then there is nothing to unlock, move to next item
            if(!adj.containsKey(item)){
                continue;
            }
            // which recipes are waiting for this ingredient?
            for(String recipe: adj.get(item)){
                indegree.put(recipe,indegree.get(recipe)-1);
                // if all the ingredients are unlocked, we made the recipe, now recipe becomes an ingredient
                if(indegree.get(recipe)==0){
                    q.add(recipe);
                    ans.add(recipe);
                }
            }
        }
        return ans;
    }
}