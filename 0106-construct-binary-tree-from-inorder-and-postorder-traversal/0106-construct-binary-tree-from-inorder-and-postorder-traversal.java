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
     int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     postIndex = postorder.length - 1;

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd,
                           Map<Integer, Integer> inMap) {

        if (inStart > inEnd) return null;
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inMap.get(rootVal);
        root.right = build(inorder, postorder, inIndex + 1, inEnd, inMap);
        root.left  = build(inorder, postorder, inStart, inIndex - 1, inMap);

        return root;
    }
}