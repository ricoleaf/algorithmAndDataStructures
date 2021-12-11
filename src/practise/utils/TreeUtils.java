package practise.utils;


import practise.utils.entity.TreeNode;

/**
 * @author wkn.uzuki
 */
public final class TreeUtils {


    public static TreeNode getPlainBinary() {

        TreeNode root = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);

        root.left = node3;
        root.right = node6;

        node3.left = node4;
        node3.right = node7;

        node6.left = node9;
        node6.right = node8;
        return root;
    }
}
