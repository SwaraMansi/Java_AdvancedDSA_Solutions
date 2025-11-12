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
    public int findBottomLeftValue(TreeNode root) {
          List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);

        return result.get(result.size() - 1);
    }

    private static void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;

        if (level == result.size()) {
            result.add(node.val);
        }

        dfs(node.left, level + 1, result);

        dfs(node.right, level + 1, result);
    }
}