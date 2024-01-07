package tree;

import javax.swing.tree.TreeCellRenderer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFS {

    //https://leetcode.com/problems/diameter-of-binary-tree/
    class Solution {
        int diameter = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            height(root);
            return diameter-1; // number of edges = number of nodes -1
        }

        private int height(TreeNode node) {
            if(node == null) {
                return 0;
            }

            int left = height(node.left);
            int right = height(node.right);

            int dia = left+right+1;
            diameter = Math.max(diameter,dia);

            return Math.max(left,right)+1;

        }
    }

    //https://leetcode.com/problems/invert-binary-tree/
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;

    }

    //https://leetcode.com/problems/maximum-depth-of-binary-tree
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right)+1;
    }

    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    public void flatten(TreeNode root) {
        if(root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        populateQueuePreOrder(queue,root);
        TreeNode node = queue.poll();
        while (!queue.isEmpty()){
            TreeNode right = queue.poll();
            if(right == null)
                continue;
            node.right = right;
            node.left = null;
            node = node.right;
        }
    }

    private void populateQueuePreOrder(Queue<TreeNode> queue, TreeNode node) {
        if(node == null)
            return;
        queue.add(node);
        populateQueuePreOrder(queue,node.left);
        populateQueuePreOrder(queue,node.right);
    }

    //https://leetcode.com/problems/validate-binary-search-tree/
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    private boolean helper(TreeNode node, Integer low, Integer high) {
        if(node == null){
            return true;
        }

        if(low != null && node.val <= low){
            return  false;
        }
        if (high != null && node.val >= high){
            return false;
        }

        return helper(node.left,low,node.val) && helper(node.right, node.val, high);
    }

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return root;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null){
            return root;
        }

        return left == null ? right : left;

    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> queue = new LinkedList<>();
        populateQueueInOrder(queue,root);
        return queue.get(k-1).val;
    }
    private void populateQueueInOrder(List<TreeNode> queue, TreeNode node) {
        if(node == null)
            return;
        populateQueueInOrder(queue,node.left);
        queue.add(node);
        populateQueueInOrder(queue,node.right);
    }
}
