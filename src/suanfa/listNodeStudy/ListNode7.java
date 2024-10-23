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
        if (head == null) return head; // 检查head是否为空

        ListNode current = head; // 初始化指针指向链表头部
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // 跳过重复节点
            } else {
                current = current.next; // 移动到下一个节点
            }
        }

        return head; // 返回去重后的链表头节点
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        deleteDuplicates(node1);
        ListNode.printNodeList(node1);
    }

    public static ListNode deleteDuplicates_test1(ListNode head) {
        if (head == null) {
            return head;
        }

        // 遍历链表，如果当前和下一个相同，则将当前的next指向next next
        ListNode current = head;
        while (current != null || current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;

    }
}