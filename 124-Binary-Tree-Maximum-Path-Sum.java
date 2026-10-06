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
    int maxsum=Integer.MIN_VALUE;
    public int path(TreeNode root){
        if(root==null)
        return 0;

        // ignore negative paths
        int left=Math.max(path(root.left),0);
        int right=Math.max(path(root.right),0);

        int pathsum=left+right+root.val;
        maxsum= Math.max(pathsum,maxsum);

        return root.val+ Math.max(left,right);

    }
    public int maxPathSum(TreeNode root) {
        path(root);
        return maxsum;
    }
}