/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root==null)
        return true; 

        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);

        boolean found=false;
        while(!q.isEmpty()){
            int size=q.size();
           
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node==null){
                    found=true;
                }
                else{
                    if(found)
                    return false;

                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
        }
        return true;
    }
}