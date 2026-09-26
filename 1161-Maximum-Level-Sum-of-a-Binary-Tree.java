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
    public int maxLevelSum(TreeNode root) {
        if(root==null)
        return 0;

        int maxsum=Integer.MIN_VALUE;
        Queue<TreeNode>q = new LinkedList<>();

        q.offer(root);
        int level=1;
        int maxlevel=Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                
                sum+=node.val;
                if(node.left!=null)
                q.offer(node.left);

                if(node.right!=null)
                q.offer(node.right);
            }
            if(sum>maxsum){
                maxsum=sum;
                maxlevel=level;
            }
            level++;
        }
        return maxlevel;
    }
}