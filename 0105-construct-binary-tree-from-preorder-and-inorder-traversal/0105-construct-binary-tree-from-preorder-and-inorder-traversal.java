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
    int preindex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(inStart>inEnd) return null;
     int rootval= preorder[preindex++];
     TreeNode root= new TreeNode(rootval);
     int inVal=inMap.get(rootval);
     root.left=build(preorder,inStart,inVal-1,inMap);
     root.right=build(preorder,inVal+1,inEnd,inMap);
     return root;
}
}