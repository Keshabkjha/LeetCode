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
    public boolean isBalanced(TreeNode root) {
        if(leftheight(root)==-1){
            return false;
        }
        return true;
        
    }

    public int leftheight(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=leftheight(root.left);
        if(lh==-1){
            return -1;
        }
        int rh=leftheight(root.right);
        if(rh==-1){
            return -1;
        }

        if(Math.abs(lh-rh)>1){
            return -1;
        }
        return Math.max(lh , rh)+1;
    }
}