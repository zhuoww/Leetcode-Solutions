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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode temp = null;
        int count = k;

        while (cur != null) {
            if (count > 1) {
                temp = pre.next;
                pre.next = cur.next;
                cur.next = cur.next.next;
                pre.next.next = temp;
                count--;
            } else {
                pre = cur;
                cur = cur.next;

                ListNode end = cur;
                for (int i = 0; i < k; i++) {
                    if (end == null) {
                        return dummy.next;
                    } else {
                        end = end.next;
                    }
                }
                count = k;
            }
        }
        return dummy.next;
    }
}