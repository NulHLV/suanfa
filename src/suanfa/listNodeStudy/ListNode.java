package suanfa.listNodeStudy;

/**
 * @author NulLV
 * @create 2024年10月22日
 */

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static void printNodeList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println("\n");
    }
}