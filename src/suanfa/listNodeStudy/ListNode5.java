package suanfa.listNodeStudy;

/**
 * 合并两个有序链表
 *
 * @author NulLV
 * @create 2024年10月22日
 */

public class ListNode5 {

    //l1 = [1, 2, 4]
    //l2 = [1, 3, 4]

    //[1, 1, 2, 3, 4, 4]
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        ListNode result = new ListNode(0);
        ListNode current = result;

        while (a != null && b != null) {
            if (a.val < b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }

            current = current.next;
        }

        // 如果一个链表已经遍历完，那么就将另一个链表的剩余部分添加到结果链表的末尾
        if (a != null) {
            current.next = a;
        } else if (b != null) {
            current.next = b;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(5);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        ListNode.printNodeList(mergeTwoLists(node1, node5));
    }
}