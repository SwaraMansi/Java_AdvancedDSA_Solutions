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
       int preIndex=0;
    Map<Integer,Integer> inorderIndexMap = new HashMap<>();
    public TreeNode bstFromPreorder(int[] preorder) {
       int[] inorder = preorder.clone();     
        Arrays.sort(inorder);   
       for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);}
           return build(preorder, 0, inorder.length - 1);
    }
        public TreeNode build(int[] preorder, int left, int right) {
      
        if (left > right) {
          return null;
        }
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = inorderIndexMap.get(rootVal);

        root.left = build(preorder, left, inorderIndex - 1);
        root.right = build(preorder, inorderIndex + 1, right);

        return root;
    }
    }
