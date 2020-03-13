public class Solution2 {
    public ListNode removeElements(ListNode head, int val){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                //前置结点prev只想的元素为需要删除的元素
                ListNode delNode = prev.next;
                delNode.next.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead;
    }
}
