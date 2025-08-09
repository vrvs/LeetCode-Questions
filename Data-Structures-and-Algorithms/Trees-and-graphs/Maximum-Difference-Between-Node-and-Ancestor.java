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
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return maxAncestorDiff(root, root.val, root.val);
        }
    }
    
    private int maxAncestorDiff(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return Math.abs(maxValue-minValue);
        }
        int currentMin = Math.min(root.val, minValue);
        int currentMax = Math.max(root.val, maxValue);
        return Math.max(
            maxAncestorDiff(root.left, currentMin, currentMax),
            maxAncestorDiff(root.right, currentMin, currentMax)
        );
    }
}