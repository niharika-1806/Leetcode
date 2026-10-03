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
    int mindiff=Integer.MAX_VALUE;
    int prev=-1;
    public void dfs(TreeNode root){
        if(root==null)
        return;

        dfs(root.left);
        if(prev!=-1)
        mindiff=Math.min(mindiff,root.val - prev);

        prev=root.val;
        dfs(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return mindiff;
    }
}