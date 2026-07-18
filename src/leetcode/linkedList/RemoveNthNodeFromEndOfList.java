package leetcode.linkedList;

/**
 * Top Interview Questions[easy]: Linked List-Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        //
    }

    static class Solution {
        static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode newHead = new ListNode(0, head);
            ListNode node1 = newHead;
            ListNode node2 = newHead;

            while(n-- > 0) {
                node2 = node2.next;
            }

            while(node2.next != null) {
                node1 = node1.next;
                node2 = node2.next;
            }

            node1.next = node1.next.next;

            return newHead.next;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
