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
    int index=0;
    HashMap<Integer,Integer>map = new HashMap<>();
    
    public TreeNode helper(int []preorder, int start, int end){
        if(start>end)
        return null;

        int rootval=preorder[index];
        TreeNode node = new TreeNode(rootval);
        index++;

        int inorderindx= map.get(rootval);
        node.left= helper(preorder,start,inorderindx-1);
        node.right= helper(preorder, inorderindx+1,end);

        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
    }
}