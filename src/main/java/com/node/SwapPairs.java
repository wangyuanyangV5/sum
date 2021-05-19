package com.node;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 */
public class SwapPairs {


        public ListNode swapPairs(ListNode head) {
            if(head == null){
                return head;
            }
            ListNode first = head;

            ListNode next = head.next;
            if(next == null){
                return head;
            }

            while (next != null){
                int tmp = first.val;
                first.val = next.val;
                next.val = tmp;

                first = next.next;
                if(first == null){
                    break;
                }

                next = first.next;
            }
            return head;
        }


    public static ListNode swapPairs1(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode next = head.next;
        if(next == null){
            return head;
        }

        ListNode tmpListNode = next.next;
        next.next = head;
        head.next = tmpListNode;
        ListNode preFirst = head;
        head = next;

        ListNode first = tmpListNode;
        if(first == null){
            return head;
        }

        next = first.next;

        while (next != null){
            tmpListNode = next.next;
            next.next = first;
            first.next = tmpListNode;
            preFirst.next = next;
            preFirst = first;
            first = tmpListNode;
            if(first == null){
                break;
            }

            next = first.next;
        }
        return head;
    }




        private static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(swapPairs1(head));
    }
}
