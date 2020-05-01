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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int val : preorder) {
            root = preorder(root, val);
        }
        return root;
    }
    
    private TreeNode preorder(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        if (root.val > val) {
            root.left = preorder(root.left, val);
        } else {
            root.right = preorder(root.right, val);
        }
        return root;
    }
}
