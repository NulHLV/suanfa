package suanfa.listNodeStudy;

import java.util.List;

/**
 * 排序链表
 *
 * @author NulLV
 * @create 2024年10月22日
 */

public class ListNode6 {
    public static ListNode sortList(ListNode head) {
        // 1) 找到链表的中点（快指针每次走两步，慢指针每次走一步，当快指针到达尾部时，慢指针正好位于中点）
        ListNode mid = getMidpoint(head);

        // 2) 拆分链表，分而治之排好两半
//        A->B->C->D->E
//        中点是C，left = A->B->C->D->E ， right = D->E
//        mid.next = null后，left变成了A->B->C，right是 D->E
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        // 3) 合并两个有序链表
        return merge(left, right);
    }

    public static ListNode getMidpoint(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current.next = (left != null) ? left : right;

        return dummy.next;
    }


    public static ListNode sortList_practice(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1) 找到中位
        ListNode mid = getMidNode_practice(head);

        // 2) 拆分链表
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        // 3) 对左右链表排序
        left = sortList_practice(left);
        right = sortList_practice(right);

        // 4) 合并链表
        return merge_practice(left, right);
    }


    public static ListNode getMidNode_practice(ListNode head) {
        // 快慢指针，快指针到尾节点是null时，慢指针刚好到中间
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode merge_practice(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode current = result;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }

            current = current.next;
        }

        current.next = left == null ? right : left;

        return result.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode result = sortList_practice(node1);
        ListNode.printNodeList(result);
    }
}