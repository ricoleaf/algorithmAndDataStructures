package practise.linkedlist;

import practise.utils.entity.ListNode;

import java.util.ArrayList;

/**
 * @author: wangkangnian
 * @since: v1.0.0
 */
public class JZ6printListFromTailToHead {
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(printListFromTailToHead(listNode1));
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode head = new ListNode(-1);
        ListNode cur = listNode;
        while (listNode != null) {
            cur = cur.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = cur;
        }
        head = head.next;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}
