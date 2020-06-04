public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        //使用虚拟头节点
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
            //将carry值对10求余得到两个链表相同位置上元素之和的个位数
            p.next = new ListNode(carry % 10);
            //如果carry值小于10，位数较大的数就不呀进位，
            // 如果carry值大于10，位数较大的数进一
            carry /= 10;
            //p指向下一位
            p = p.next;
        }
        return dummyHead.next;
    }
}
