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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        if(root!=null) {
            queue.offer(root);
        }
        boolean isNextLeftToRight = false;
        while(!queue.isEmpty()) {
            int nodesCurrentLevel = queue.size();
            LinkedList<Integer> currentLevelResult = new LinkedList();
            for(int i=0;i<nodesCurrentLevel;i++) {
                TreeNode current = queue.poll();
                currentLevelResult.add(current.val);
                if(current.left!=null) {
                    queue.offer(current.left);
                }
                if(current.right!=null) {
                    queue.offer(current.right);
                }
            }
            if (isNextLeftToRight) {
                Collections.reverse(currentLevelResult);
            }
            isNextLeftToRight = !isNextLeftToRight;
            result.add(currentLevelResult);
        }
        return result;
    }
}