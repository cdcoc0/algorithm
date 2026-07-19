package leetcode.trees;

/**
 * Top Interview Questions[easy]: Trees-Maximum Depth of Binary Tree
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        //
    }

    static class Solution {
//        static int recursive(TreeNode node, int depth) {
//            if(node == null) return depth;
//            return Math.max(recursive(node.left, depth + 1), recursive(node.right, depth + 1));
//        }

        static int maxDepth(TreeNode root) {
            if(root == null) return 0;
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

//            return recursive(root, 0);
        }
    }

    /**
    * Definition for a binary tree node.
    */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
