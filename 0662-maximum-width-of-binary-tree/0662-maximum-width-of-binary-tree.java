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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair<TreeNode,Long>> q= new LinkedList<>();
        q.offer(new Pair<>(root,1L));
        int maxi=0;
while(!q.isEmpty()){
    int size= q.size();
    long min= q.peek().getValue();
    long first=0, last=0;

    for(int i=0;i<size;i++){
        Pair<TreeNode,Long> p= q.poll();
        TreeNode node = p.getKey();
        long idx= p.getValue()-min;

        if(i==0) first=idx;
        if(i==size-1) last=idx;
        if(node.left!=null)
        q.offer(new Pair<>(node.left,2*idx));
        if(node.right!=null)
        q.offer(new Pair<>(node.right,2*idx+1));
    }
    maxi= Math.max(maxi,(int)(last-first+1));
}
return maxi;
    }
}