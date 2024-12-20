class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 0);
        return root;
    }
    public void dfs(TreeNode n1, TreeNode n2, int level) {
        if(n1 == null || n2 == null)
            return;
        if(level % 2 == 0) {
            int temp = n1.val;
            n1.val = n2.val;
            n2.val = temp;
        }
        dfs(n1.left, n2.right, level + 1);
        dfs(n1.right, n2.left, level + 1);
    }
}