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
    public boolean findTarget(TreeNode root, int k) {
        
        return traversal(root,k,root);
    }
    public static TreeNode search(TreeNode root, int i) {
        if (root!=null) {
            if (root.val==i) return root;
            if (root.val>i) return search(root.left,i);
            if (root.val<i) return search(root.right,i);
        }
        return null;
    }
    public static boolean traversal(TreeNode node, int k, TreeNode root) {
        if (node!=null) {
            if (traversal(node.left,k,root)) return true;
            if (traversal(node.right,k,root)) return true;
            TreeNode temp=search(root,(k-node.val));
            if (temp!=null && temp.val!=node.val) return true;
        }
        return false;
    }
}

// a little bit slower
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
    public boolean findTarget(TreeNode root, int k) {
        
        return traversal(root,k,root);
    }
    public static TreeNode search(TreeNode root, int i) {
        if (root!=null) {
            if (root.val==i) return root;
            if (root.val>i) return search(root.left,i);
            if (root.val<i) return search(root.right,i);
        }
        return null;
    }
    public static boolean traversal(TreeNode node, int k, TreeNode root) {
        if (node!=null) {
            //if (traversal(node.left,k,root)) return true;
            //if (traversal(node.right,k,root)) return true;
            TreeNode temp=search(root,(k-node.val));
            if (temp!=null && temp.val!=node.val) return true;
            return traversal(node.left,k,root) || traversal(node.right,k,root);
        }
        return false;
    }
}
