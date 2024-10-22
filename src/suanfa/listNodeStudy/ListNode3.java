package suanfa.listNodeStudy;

import org.w3c.dom.NodeList;

/**
 * 删除节点
 *
 * @author NulLV
 * @create 2024年10月22日
 */

public class ListNode3 {
    public static void deleteNode(ListNode node) {
        //将要删除的节点的下一个节点的值复制到当前节点，然后将当前节点的指向为下一个节点的下一个节点。这样就避免了直接操作链表的头节点或前置节点
        // node 是在链表中的一个有效节点，并且不为链表的尾节点。
        if (node == null || node.next == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode.printNodeList(node1);
        deleteNode(node4);
        ListNode.printNodeList(node1);
    }

    public static void test(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}