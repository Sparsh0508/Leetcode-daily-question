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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }
        ListNode temp = head;
        int len = 1 ;
        while(temp.next!=null){
            temp =temp.next;
            len++;
        }
        temp.next = head;
        k = k % len;
        int newTailIndex = len - k - 1;
        temp = head;
        for(int i = 0;i<newTailIndex;i++){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}