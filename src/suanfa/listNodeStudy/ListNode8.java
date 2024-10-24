package suanfa.listNodeStudy;

import java.util.List;

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
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode.printNodeList(reverseBetween_test2(node1, 2, 4));
    }

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

    public static ListNode reverseBetween_test(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode prev = result;

        // 1）找到pre节点
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }


        // 2）找到子链表的头节点和头节点下一个节点  A B C -> 将C插到AB中间
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

    public static ListNode reverseBetween_test1(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }

        // 获取m节点前后两个节点，将m后一个节点插到m节点前 完成反转
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode then = start.next;

        for (int i = 0; i < n - m; i++) {
            // 将then插到pre和start中间  pre start then
            start.next = then.next; // 断链
            then.next = pre.next; // then指向start
            pre.next = then; // pre指向新的头节点
            then = start.next; // 移动then指针为下一个
        }

        // 1 2 3 4 5     1 3 2 4 5

        return result.next;
    }


    public static ListNode reverseBetween_test2(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode then = start.next;

        for (int i = 0; i < n - m; i++) {
            //  pre start then
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return result.next;
    }
}