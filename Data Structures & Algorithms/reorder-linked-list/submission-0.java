class Solution {
    public void reorderList(ListNode head) {
        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode temp = slow.next;
        slow.next = null;

        ListNode prev = null;

        while (temp != null) {
            ListNode nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
        }

        // 3. Merge two halves
        ListNode f = head;
        ListNode l = prev;

        while (l != null) {
            ListNode tmp = f.next;
            ListNode tmp2 = l.next;

            f.next = l;
            l.next = tmp;

            f = tmp;
            l = tmp2;
        }
    }
}