package com.node;

import java.util.Objects;

/**
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 * 示例 3：
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 *
 *
 * 示例 4：
 * 输入：head = [1], k = 1
 * 输出：[1]
 *
 * 提示：
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 *
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 */
public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }
        int count = 1;
        ListNode nowHead = head;
        ListNode nextHead = null;
        ListNode end = head;
        ListNode resultHead = null;
        ListNode lastHead = nowHead;
        while (end!= null){
            nextHead = end.next;
            if(count % k == 0){
                ListNode tmpHead = changeNode(nowHead,nextHead);
                if(resultHead == null){
                    resultHead = tmpHead;
                    lastHead.next = nextHead;
                }else {
                    lastHead.next = tmpHead;
                    lastHead = nowHead;
                }


                nowHead = nextHead;
            }
            end = nextHead;
            count++;
        }
        return resultHead == null ? head : resultHead;
    }


    private static ListNode  changeNode(ListNode heard,ListNode end){
        ListNode first = heard;
        if(Objects.isNull(first)){
            return heard;
        }

        ListNode next = first.next;
        if(next == end || Objects.isNull(next)){
            return heard;
        }
        ListNode tmp = next.next;
        ListNode lastNode = end;
        while (true){
            next.next = first;
            first.next = lastNode;
            first = tmp;
            lastNode = next;
            if(first == end ||Objects.isNull(first)){
                break;
            }

            next = first.next;
            if(next == end || Objects.isNull(next)){
                break;
            }
            tmp = next.next;
        }
        if(first != end){
            first.next = lastNode;
            return first;
        }else {
            return lastNode;
        }
    }

    public static class ListNode {
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
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(reverseKGroup(head,2));
    }
}
