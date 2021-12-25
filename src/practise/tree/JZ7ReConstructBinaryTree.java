package practise.tree;

import practise.utils.TreeUtils;
import practise.utils.entity.TreeNode;

import java.util.Arrays;

import static practise.tree.JZ78PrintBinary.Print;

/**
 * 给定节点数为 n 二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
 *
 * @author: wangkangnian
 * @since: v1.0.0
 */
public class JZ7ReConstructBinaryTree {

    public static void main(String[] args) {

        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] vin = new int[]{4,7,2,1,5,3,8,6};

        System.out.println(Print(reConstructBinaryTree(pre, vin)));

    }

    public static TreeNode reConstructBinaryTree(int [] pre, int [] vin) {
        if (pre.length == 0) {
            return null;
        }
        if(pre.length == 1){
            return new TreeNode(pre[0]);
        }
        TreeNode root = new TreeNode(pre[0]);
        int j = 0;
        for (; j < vin.length; j++) {
            if (vin[j] == pre[0]) {
                break;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, j + 1), Arrays.copyOfRange(vin, 0, j));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, j + 1, pre.length), Arrays.copyOfRange(vin, j + 1, vin.length));
        return root;
    }

}
