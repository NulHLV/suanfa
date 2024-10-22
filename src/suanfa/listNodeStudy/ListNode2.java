package suanfa.listNodeStudy;

/**
 * 链表是否有环
 *
 * @author NulLV
 * @create 2024年10月22日
 */

public class ListNode2 {
    public static boolean hasCycle(ListNode head) {
        //判断链表中是否存在环可以通过“快慢指针”（又称为龟兔赛跑算法）来解决。
        // 快指针每次移动两个节点，慢指针每次移动一个节点。
        // 如果链表中存在环，快指针最终会和慢指针相遇；如果没有环，快指针会在慢指针移动到链表末尾之前“跑”到 null。

        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        ListNode current = node1;
        System.out.println(hasCycle(current));
    }
}