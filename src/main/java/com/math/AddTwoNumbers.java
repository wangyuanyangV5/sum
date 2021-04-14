package com.math;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 */
public class AddTwoNumbers {
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode head = null;
        ListNode tail = null;
        ListNode first = l1;
        ListNode thrend = l2;
        while (first != null && thrend != null){
            int sum = 0;
            sum = add + (first.val + thrend.val);

            add = sum / 10;

            ListNode now = new ListNode(sum % 10);
            if(head == null){
                head = now;
                tail = now;
            }else {
                tail.next = now;
                tail = now;
            }
            first = first.next;
            thrend = thrend.next;
        }

        if(first != null){
            if(head == null){
                return first;
            }else {
                while (first != null){
                    tail.next = first;
                    if(add != 0){
                        int sum = first.val + add;
                        first.val = sum % 10;
                        add = sum /10;
                    }
                    tail = first;
                    first = first.next;
                }
            }
        }

        if (thrend != null){
            if(head == null){
                return first;
            }else {
                while (thrend != null){
                    tail.next = thrend;
                    if(add != 0){
                        int sum = thrend.val + add;
                        thrend.val = sum % 10;
                        add = sum /10;
                    }
                    tail = thrend;
                    thrend = thrend.next;
                }
            }
        }
        if(add > 0){
            tail.next = new ListNode(add);
        }

        return head;
    }

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
