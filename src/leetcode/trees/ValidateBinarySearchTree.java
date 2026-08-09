package leetcode.trees;

/**
 * Top Interview Questions[easy]: Trees-Validate Binary Search Tree
 */
public class ValidateBinarySearchTree {
    static void main(String[] args) {
    }

    static class Solution {
        static boolean check(long min, long max, TreeNode node) {
            if(node == null) return true;

            if(node.val <= min || node.val >= max) return false;

            return check(min, node.val, node.left) && check(node.val, max, node.right);
        }

        static boolean isValidBST(TreeNode root) {
            return check(Long.MIN_VALUE, Long.MAX_VALUE, root);
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
