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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()){
            int level = q.size();
            for(int i=0;i<level;i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            int arr[] = new int[q.size()];
            int i=0;
            for(TreeNode num : q){
                arr[i] = num.val;
                i++;
            }
            count = count+minswap(arr,i);
        }
        return count;
    }
    private int minswap(int[] arr,int N){
        int ans = 0;
        int[] temp = Arrays.copyOfRange(arr,0,N);
        Arrays.sort(temp);
        for(int i=0;i<N;i++){
            if(arr[i]!=temp[i]){
                ans++;
                swap(arr,i,indexof(arr,temp[i]));
            }
        }
        return ans;
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private int indexof(int[] arr,int number){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==number){
                return i;
            }
        }
        return -1;
    }
}