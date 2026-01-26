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
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    boolean reverse;   // false = inorder, true = reverse inorder

    public BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = reverse ? node.right : node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        if (reverse)
            pushAll(node.left);
        else
            pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
      if (root == null) return false;

        BSTIterator left = new BSTIterator(root, false);  // smallest
        BSTIterator right = new BSTIterator(root, true); // largest

        int i = left.next();
        int j = right.next();

        while (i < j) {
            int sum = i + j;

            if (sum == k) return true;
            else if (sum < k)
                i = left.next();   // move left pointer forward
            else
                j = right.next();  // move right pointer backward
        }
        return false;
    }  
    }