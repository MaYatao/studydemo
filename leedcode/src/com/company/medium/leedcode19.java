package com.company.medium;

/**
 * leedcode19：
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 *
 * @Description 描述
 * @author: yatao.ma
 * @date: 2020/7/16 9:58 上午
 */
public class leedcode19 {

    public static void main(String[] args) {
       ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
       ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode result=   removeNthFromEnd(node1,2);
        System.out.println(result.val);
    }
    public  static ListNode removeNthFromEnd(ListNode head, int n) {
    //哑节点，避免删除头部等极端情况
        ListNode node=new ListNode(0);
        node.next=head;
        ListNode  pre=node;
        ListNode next=node;
         while(n>0 ){
             pre=pre.next;
             n--;
         }
         if(n>0){
             return  null;
         }
          while(pre!=null){
              pre=pre.next;
              next=next.next;
          }

        next.next=next.next.next;

        return  node.next;
    }
}
