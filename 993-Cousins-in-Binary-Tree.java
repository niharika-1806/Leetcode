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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode>q = new LinkedList<>();

        q.offer(root);
        TreeNode parent=root;
        while(!q.isEmpty()){
            int size=q.size();
            boolean foundx=false;
            boolean foundy=false;
            List<Integer>level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();

                // check if same parent
                if(node.left!=null && node.right!=null){
                    if((node.left.val==x && node.right.val==y) ||
                    (node.right.val==x && node.left.val==y)){
                        return false;
                    }
                }

                if(node.val==x)
                foundx=true;

                if(node.val==y)
                foundy=true;

                if(node.left!=null)
                q.offer(node.left);

                if(node.right!=null)
                q.offer(node.right);

            }
            if(foundx && foundy)
            return true;

            if(foundx || foundy)
            return false;
        }
        return false;
    }
}