/*
 * medium
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

// time:O(n);space:O(1)
class Solution {
    public void reorderList(ListNode head) {
        // seperate the head to two parts
        ListNode slow = head;
        ListNode fast = head;

        // find the middle point
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the right part of the list
        ListNode right = reverse(slow.next);
        slow.next = null;
        ListNode left = head;

        // merge the two parts of the lists
        merge(left, right);
    }

    // reverse function
    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // merge funtion
    public void merge(ListNode list1, ListNode list2) {
        while (list2 != null) {
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;

            list1.next = list2;
            list2.next = temp1;

            list1 = temp1;
            list2 = temp2;
        }
    }
}

// deque:time:O(n);space:O(n)
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
        if (head == null)
            return;

        Deque<ListNode> q = new LinkedList<>();
        ListNode cur = head.next;
        while (cur != null) {
            q.offer(cur);
            cur = cur.next;
        }

        cur = head;
        int count = 0;

        while (!q.isEmpty()) {
            if (count % 2 == 0) {
                cur.next = q.pollLast();
            } else {
                cur.next = q.poll();
            }
            cur = cur.next;
            count++;
        }
        cur.next = null;
    }
}