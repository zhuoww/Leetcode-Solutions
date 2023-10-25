/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverse(slow);
        pre.next = null;

        merge(head, second);
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public void merge(ListNode l1, ListNode l2) {
        while (true) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;

            l1.next = l2;
            if (temp1 == null)
                return;
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }

    /**
     * 1 -> 2
     * l1 temp1
     * 
     * 5 -> 4 -> 3
     * l2 temp2
     * 
     */

}