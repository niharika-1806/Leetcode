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
    int sum=0;
    int maxdepth=0;
    public void dfs(TreeNode root,int currdepth){
        if(root==null)
        return;

        if(root.left==null && root.right==null){
            if(currdepth>maxdepth){
                maxdepth=currdepth;
                sum=root.val;
            }
            else if(currdepth==maxdepth){
                sum+=root.val;
            }
        }
        
        dfs(root.left,currdepth+1);
        dfs(root.right,currdepth+1);
    }
    public int deepestLeavesSum(TreeNode root) {
        if(root==null)
        return 0;

        dfs(root,1);
        return sum;
    }
}