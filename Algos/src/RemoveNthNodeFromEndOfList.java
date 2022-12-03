package com.test.web3labs;


import java.util.List;
import java.util.Objects;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(Objects.isNull(head)) return null;
        head = reverse(head);
        if(n == 1) {
            head = head.next;
        } else {
            ListNode previous = head;
            ListNode pointer = head.next;
            for(int x=1; x < n - 1 ; x++) {
                previous = pointer;
                pointer = pointer.next;
            }
            previous.next = pointer.next;
        }

        head = reverse(head);
        return head;
    }

    public ListNode reverse(ListNode head) {
        ListNode pointer = head;
        ListNode previous = null;

        while(!Objects.isNull(pointer)) {
            ListNode current = pointer;
            pointer = pointer.next;


            current.next = previous;
            previous = current;
            head = current;
        }
        return head;
    }

    private static void toString (ListNode head) {
        ListNode pointer = head;
        while(!Objects.isNull(pointer)) {
            System.out.print(pointer.val +" ");
            pointer = pointer.next;
        }
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList rm = new RemoveNthNodeFromEndOfList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        toString(rm.removeNthFromEnd(head, 5));
    }
}
