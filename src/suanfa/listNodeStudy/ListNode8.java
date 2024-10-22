package suanfa.listNodeStudy;

/**
 * 反转链表的部分节点
 *
 * @author NulLV
 * @create 2024年10月22日
 */

public class ListNode8 {
    // head = [1, 2, 3, 4, 5]
    // m = 2
    // n = 4

    // 链表的结构为：1 -> 2 -> 3 -> 4 -> 5，需要反转从位置 2 到位置 4 的部分。   输出  [1, 4, 3, 2, 5]

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode prev = result;

        // 1) 将 prev 指针移动到反转开始之前的节点
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }

        // 2) 在m和n之间进行反转
        ListNode start = prev.next;
        ListNode then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return result.next;
    }
}