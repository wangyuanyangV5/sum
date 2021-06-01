package com.node;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动k个位置。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * 提示：
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * 链接：https://leetcode-cn.com/problems/rotate-list
 */
public class RotateRight {
    public static void main(String[] args) {
        RotateRight rotateRight = new RotateRight();
        ListNode tmp = null;
        ListNode head = null;

//        head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        tmp = rotateRight.rotateRight(head,2);

        head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        tmp = rotateRight.rotateRight(head,4);

        System.out.print("[");
        while (tmp != null){
            System.out.print(tmp.val);
            System.out.print(" ");
            tmp = tmp.next;
        }
        System.out.print("]");
        System.out.println("");
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null){
            return head;
        }

        ListNode tmp = head;
        for(int i = 0;i < k ;i++){
            tmp = tmp.next;
            if(tmp == null){
                tmp = head;
            }
        }
        if(tmp == head){
            return head;
        }

        ListNode first = head;
        ListNode second = tmp;
        while (second.next != null){
            first = first.next;
            second = second.next;
        }

        second.next = head;
        ListNode resultHead = first.next;
        first.next = null;
        return resultHead;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
