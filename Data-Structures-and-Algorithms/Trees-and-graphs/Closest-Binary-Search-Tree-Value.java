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
    int result = 0;
    double diff = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        search(root, target);
        return result;
    }
    
    public void search(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        if (Math.abs(target-root.val)<=diff) {
            if(Math.abs(target-root.val)==diff) {
                result = Math.min(root.val, result);
            } else {
                result = root.val;
            }
            diff = Math.abs(target-root.val);
            search(root.right, target);
            search(root.left, target);
        } else {
            if (target>root.val) {
                search(root.right, target);
            } else {
                search(root.left, target);
            }
        }
        
    }
}