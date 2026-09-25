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
    public int dfs(TreeNode root, int mini, int maxi){
        if(root==null)
        return Math.abs(mini-maxi);

        mini=Math.min(mini,root.val);
        maxi=Math.max(maxi,root.val);

        int leftree=dfs(root.left,mini,maxi);
        int righttree=dfs(root.right,mini,maxi);

        return Math.max(leftree,righttree);

    }
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
}