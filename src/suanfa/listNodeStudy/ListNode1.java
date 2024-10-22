package suanfa.listNodeStudy;

/**
 * 反转链表
 *
 * @author NulLV
 * @create 2024年10月22日
 */

public class ListNode1 {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;  // 前一个节点
        ListNode current = head;  // 当前节点
        while (current != null) {
            ListNode nextNode = current.next;  // 暂存下一个节点
            current.next = prev;  // 当前节点反转指向前一个节点
            prev = current;  // 前一个节点移到当前节点的位置
            current = nextNode;  // 当前节点移到下一个节点的位置
        }
        return prev;  // 新的头节点
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        // 反转前
        ListNode.printNodeList(node1);
        // 反转后
        ListNode reversedHead = reverseList(node1);
        ListNode.printNodeList(reversedHead);
    }
}