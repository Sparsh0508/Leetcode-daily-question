class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        Stack<ListNode> st = new Stack<>();
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            int cnt = 0;
            ListNode temp = curr;

            while (temp != null && cnt < k) {
                st.push(temp);
                temp = temp.next;
                cnt++;
            }

            if (cnt < k) {
                prev.next = curr;
                break;
            }

            while (!st.isEmpty()) {
                prev.next = st.pop();
                prev = prev.next;
            }

            prev.next = temp;
            curr = temp;
        }

        return dummy.next;
    }
}
