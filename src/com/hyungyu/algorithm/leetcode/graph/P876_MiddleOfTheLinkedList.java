package com.hyungyu.algorithm.leetcode.graph;

public class P876_MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
            new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode listNode = middleNode(head);
        System.out.println(listNode.val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode middle = head;
        ListNode end = head;

        while (end != null && end.next != null) {
            middle = middle.next;
            end = end.next.next;
        }

        return middle;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
