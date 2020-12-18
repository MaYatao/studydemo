package com.company.medium;

/**
 * leedcode24：
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @Description 描述
 * @author: yatao.ma
 * @date: 2020/7/22 9:41 上午
 */
public class leedcode24 {
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
        ListNode result = swapPairs(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
  /*
   //如果头节点为空或者只有一个节点
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // 现在头节点是第二个了
        return secondNode;

 */

        ListNode node = new ListNode(-1);
        ListNode res = node;
        while (head != null && head.next != null) {
            node.next = head.next;
            head.next = head.next.next;
            node.next.next = head;

            node = node.next.next;
            head = head.next;

        }
        return res.next;


    }

}
