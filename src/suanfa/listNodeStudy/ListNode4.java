package suanfa.listNodeStudy;

/**
 * 实现两个链表的相加
 *
 * @author NulLV
 * @create 2024年10月22日
 */

public class ListNode4 {
    // 输入 l1 = [2, 4, 3]   l2 = [5, 6, 4]   链表 l1 表示数字 342，链表 l2 表示数字 465。
    // 输出 [7, 0, 8]                         链表 l1 和 l2 的和为 807，它的逆序表示为 [7, 0, 8]。
    public static ListNode add(ListNode head1, ListNode head2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        ListNode current1 = head1;
        ListNode current2 = head2;

        int carry = 0;

        while (current1 != null || current2 != null) {
            int x = current1 != null ? current1.val : 0;
            int y = current2 != null ? current2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10; // 进位
            current.next = new ListNode(sum % 10); // 个位
            current = current.next;

            if (current1 != null) {
                current1 = current1.next;
            }

            if (current2 != null) {
                current2 = current2.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(5);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        ListNode.printNodeList(add(node1, node5));
    }

    public static ListNode add_test(ListNode head1, ListNode head2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        ListNode a = head1;
        ListNode b = head2;

        int carry = 0;

        while (a != null || b != null) {
            int x = a != null ? a.val : 0;
            int y = b != null ? b.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (a != null) {
                a = a.next;
            }

            if (b != null) {
                b = b.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return result.next;
    }
}