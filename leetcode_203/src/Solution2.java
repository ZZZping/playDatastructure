public class Solution2 {
    public ListNode removeElements(ListNode head, int val){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                //ǰ�ý��prevֻ���Ԫ��Ϊ��Ҫɾ����Ԫ��
                ListNode delNode = prev.next;
                delNode.next.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead;
    }
}
