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
        int pos=0;
        TreeNode curr=root,temp=null;
        while(curr!=null){
            if(curr.left==null){
                pos++;
                if(pos==k) break;
                curr=curr.right;
            }
            else{
                temp=curr.left;
                while(temp.right!=null && temp.right!=curr) temp=temp.right;
                if(temp.right==null){
                 temp.right=curr;
                curr=curr.left;
                }
                else{
                    pos++;
                    if(pos==k) break;
                    curr=curr.right;
                }
            }
        }
        return curr.val;

    }
}