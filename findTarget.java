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
        if (root!=null && (root.left!=null || root.right!=null)) {
            if (root.val>k) {
                findTarget(root.left,k);
            } else {
                TreeNode temp=search(root,k-root.val);
                /*if (temp!=null) {
                    System.out.println("temp="+temp.val+"; k-root.val="+(k-root.val)+(temp.val==(k-root.val)));
                }*/
                if (temp!=null && (temp.val==(k-root.val))) {
                    return true;
                }
                if (root.left!=null) {
                    return findTarget(root.left,k);
                }
                if (root.right!=null) {
                    return findTarget(root.right,k);
                }
            }
        }
        return false;
    }
    public static TreeNode search(TreeNode root, int i) {
        if (root!=null) {
            //System.out.println(root.val+"; i="+i);
            if (root.val==i) return root;
            if (root.val>i) return search(root.left,i);
            if (root.val<i) return search(root.right,i);
        }
        return null;
    }
}