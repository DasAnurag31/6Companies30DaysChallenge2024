// https://leetcode.com/problems/trim-a-binary-search-tree/
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val == low) {
            root.left = null;
        }
        if (root.val == high) {
            root.right = null;
        }
        while (root != null && (root.val < low || root.val > high)) {
            if (root != null && root.val < low) {
                root = root.right;
            }
            if (root != null && root.val > high) {
                root = root.left;
            }
        }
        if (root == null) {
            return null;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}