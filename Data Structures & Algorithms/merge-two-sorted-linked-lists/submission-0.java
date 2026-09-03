/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        ListNode head = new ListNode();
        ListNode temp = head;


        while(cur1 != null && cur2 != null) {
             if(cur2.val >= cur1.val) {
                temp.next = cur1;
                cur1 = cur1.next;
             } else {
                temp.next = cur2;
                cur2 = cur2.next;
             }

             temp = temp.next;
        }

        temp.next = (cur1 != null) ? cur1 : cur2;
       

        return head.next;
    }
}