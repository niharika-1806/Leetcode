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
    List<Integer>nodes = new ArrayList<>();
    public void inorder(TreeNode root){
        if(root==null)
        return;

        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);
    }
    public TreeNode findmid(int low, int high){
        if(low>high)
        return null;

        int mid=low + (high-low)/2;
        TreeNode root= new TreeNode (nodes.get(mid));

        root.left=findmid(low,mid-1);
        root.right=findmid(mid+1,high);

        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return findmid(0,nodes.size() -1);
    }
}