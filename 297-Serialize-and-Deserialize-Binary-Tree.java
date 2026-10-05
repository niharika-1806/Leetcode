/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public void helper1(TreeNode root, StringBuilder str){
        if(root==null){
            str.append("N,");
            return;
        }
        str.append(root.val).append(",");
        helper1(root.left,str);
        helper1(root.right,str);
    }
    public String serialize(TreeNode root) {
        StringBuilder str= new StringBuilder();
        helper1(root,str);
        return str.toString();
    }

    // Decodes your encoded data to tree.
    int index=0;
    public TreeNode helper2(String values[]){
        if(values[index].equals("N")){
            index++;
            return null;
        }
        TreeNode root= new TreeNode(Integer.parseInt(values[index]));
        index++;

        root.left= helper2(values);
        root.right= helper2(values);

        return root;
    }
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
        return null;

        String values[]=data.split(",");
        index=0;

        return helper2(values);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));