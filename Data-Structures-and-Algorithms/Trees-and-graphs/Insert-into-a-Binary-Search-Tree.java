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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            TreeNode curr = insertIntoBST(root.right, val);
            if (root.right == null) {
                root.right = curr;
            }
        } else {
            TreeNode curr = insertIntoBST(root.left, val);
            if (root.left == null) {
                root.left = curr;
            }
        }
        return root;
    }
}