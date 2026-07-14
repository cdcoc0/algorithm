package leetcode.linkedList;

/**
 * Top Interview Questions[easy]: Linked List-Delete Node in a Linked List
 */
public class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        //
    }

    static class Solution {
        static void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    /**
     * Definition for singly-linked list.
     */
     static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }
}
