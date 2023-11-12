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
    public ListNode mergeKLists(ListNode[] lists) {
        // time: O(nlogk), space: O(k)
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;

            if (node.next != null) {
                minHeap.add(node.next);
            }

            cur = cur.next;
        }
        return dummy.next;

    }
}
