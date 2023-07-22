package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // time: O(max(N, M))--N and M are the lengths of l1 and l2, iterates through
        // the linked lists once
        // space: O(max(N, M))--new ListNode
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10; // quotient
            int remainder = sum % 10; // remainder

            ListNode newNode = new ListNode(remainder);
            cur.next = newNode;

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
