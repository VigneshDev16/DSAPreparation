package tree;

public class PathSum {

    //https://leetcode.com/problems/path-sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        if(root.val == targetSum && root.left == null && root.right == null){
            return true;
        }

        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }

    //https://leetcode.com/problems/sum-root-to-leaf-numbers/
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    int sumNumbers(TreeNode node, int sum) {
        if(node == null) {
            return 0;
        }
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return sumNumbers(node.left, sum) + sumNumbers(node.right, sum);
    }

    //https://leetcode.com/problems/binary-tree-maximum-path-sum/
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return ans;
    }

    private int maxPathSumHelper(TreeNode node) {
        if(node == null){
            return 0;
        }

        int left = maxPathSumHelper(node.left);
        int right = maxPathSumHelper(node.right);

        left = Math.max(0,left); //-> ignore if negative
        right = Math.max(0,right);

        int pathSum = left + right + node.val;
        ans = Math.max(ans,pathSum);

        return  Math.max(left, right) + node.val;

    }
}
