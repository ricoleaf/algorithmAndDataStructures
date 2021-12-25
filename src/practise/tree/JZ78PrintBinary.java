package practise.tree;

import practise.utils.TreeUtils;
import practise.utils.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个节点数为 n 二叉树，要求从上到下按层打印二叉树的 val 值，
 * 同一层结点从左至右输出，每一层输出一行，将输出的结果存放到一个二维数组中返回。
 * @author: wangkangnian
 * @since: v1.0.0
 */
public class JZ78PrintBinary {
    public static void main(String[] args) {

        System.out.println(Print(TreeUtils.getPlainBinary()));
    }
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        TreeNode last = pRoot;
        TreeNode nlast = null;
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp != null) {
                list.add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                    nlast = tmp.left;
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                    nlast = tmp.right;
                }
                if (last == tmp) {
                    last = nlast;
                    result.add(new ArrayList<>(list));
                    list.clear();
                }
            }
        }
        return result;
    }
}
