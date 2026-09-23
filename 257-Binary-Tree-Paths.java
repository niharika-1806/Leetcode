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
    List<String>result=new ArrayList<>();
    public void dfs(TreeNode root, StringBuilder str){
        if(root==null)
        return;

        int len=str.length();
        str.append(root.val);
        
        if(root.left==null && root.right==null){
            result.add(str.toString());
        }
        str.append("->");
        dfs(root.left,str);
        dfs(root.right,str);
        str.setLength(len);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)
        return new ArrayList<>();

        StringBuilder str=new StringBuilder();

        dfs(root,str);
        return result;
    }
}