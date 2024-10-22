package suanfa.listNodeStudy;

/**
 * 给定一个已排序的链表 head，请删除链表中所有重复的元素，使得每个元素只出现一次，并返回链表的头节点。
 *
 * @author NulLV
 * @create 2024年10月22日
 */

public class ListNode7 {
    // head = [1, 1, 2, 3, 3]
    // [1, 2, 3]

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        deleteDuplicates(node1);
        ListNode.printNodeList(node1);
    }
}