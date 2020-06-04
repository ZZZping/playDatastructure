public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        //ʹ������ͷ�ڵ�
        ListNode p, dummyHead = new ListNode(0);
        p = dummyHead;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            //��carryֵ��10����õ�����������ͬλ����Ԫ��֮�͵ĸ�λ��
            p.next = new ListNode(carry % 10);
            //���carryֵС��10��λ���ϴ�����Ͳ�ѽ��λ��
            // ���carryֵ����10��λ���ϴ������һ
            carry /= 10;
            //pָ����һλ
            p = p.next;
        }
        return dummyHead.next;
    }
}
