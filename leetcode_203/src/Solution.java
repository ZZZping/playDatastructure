public class Solution {
    public ListNode removeElements(ListNode head, int val){
        //Á´±íÎª¿Õ
        while (head != null && head.val ==val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null) {
            return null;
        }
        for (ListNode prev = head; prev != null; prev = prev.next) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
