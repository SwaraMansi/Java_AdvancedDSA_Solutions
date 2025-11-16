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
    public int kthSmallest(TreeNode root, int k) {
      int[] counter = new int[]{0};   
        int[] result = new int[]{-1};      
        inorder(root, counter, k, result);
        return result[0];
    }

    private void inorder(TreeNode root, int[] counter, int k, int[] result) {
        if (root == null) return;
        if (result[0] != -1) return;       

        inorder(root.left, counter, k, result);

        counter[0]++;                      
        if (counter[0] == k) {              
            result[0] = root.val;
            return;
        }

        inorder(root.right, counter, k, result);
    }
}