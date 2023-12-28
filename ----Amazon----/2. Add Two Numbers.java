/*
 * medium
 * time:O(n),n-> Maximum of lengths of l1 and l2
 * space:O(n),n-> Maximum of lengths of l1 and l2
 */

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10;
            int remainder = sum % 10;

            ListNode temp = new ListNode(remainder);
            cur.next = temp;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            cur = cur.next;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            cur.next = newNode;
            newNode.next = null;
        }
        return dummy.next;
    }
}