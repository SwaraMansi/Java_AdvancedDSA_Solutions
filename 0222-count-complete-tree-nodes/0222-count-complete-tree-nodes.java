class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public int countNodes(TreeNode root) {
             List<Integer> arr = new ArrayList<>();
        postorder(root, arr);
        return arr.size();
    }

    private void postorder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return; 
        }
        postorder(root.left, arr);
        arr.add(root.val);
        postorder(root.right, arr);
       
    }
}
