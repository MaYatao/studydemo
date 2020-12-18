package com.company.medium;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */

 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Leedcode2 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
    /*    node1.next=node2;
        node2.next=node3;

        node4.next=node5;
        node5.next=node6;*/
        addTwoNumbers(node1, node4);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode cur = node;
        int jin = 0;
        while (l1 != null || l2 != null) {
            ListNode tempNode;
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int temp = x + y + jin;
            if (temp < 10) {
                tempNode = new ListNode(temp);
                jin = 0;
            } else {
                tempNode = new ListNode(temp % 10);
                jin = 1;
            }
            cur.next = tempNode;
            cur = cur.next;
            if(l1.next!=null) {
                l1 = l1.next;
            }
            if(l2.next!=null) {
                l2 = l2.next;
            }
        }
        if (jin == 1) {
            cur.next = new ListNode(jin);
        }

        return node.next;

/*
       ListNode dummyHead = new ListNode(0);  //头节点
         ListNode p = l1, q = l2, curr = dummyHead;   //当前节点等于头节点
         int carry = 0;  //进制
         while (p != null || q != null) {
             int x = (p != null) ? p.val : 0;
             int y = (q != null) ? q.val : 0;
             int sum = carry + x + y;
             carry = sum / 10;
             curr.next = new ListNode(sum % 10);
             curr = curr.next;
             if (p != null) {
                 p = p.next;
             }
             if (q != null) q = q.next;
         }
         if (carry > 0) {
             curr.next = new ListNode(carry);
         }
         return dummyHead.next;
*/

    }
}
