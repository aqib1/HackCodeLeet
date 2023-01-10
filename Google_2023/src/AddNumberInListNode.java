public class AddNumberInListNode {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pointer = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if(l1 != null) {
                sum+= l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum+= l2.val;
                l2 = l2.next;
            }
            sum += carry;
            pointer.next = new ListNode(sum % 10);
            carry = sum / 10;
            pointer = pointer.next;
        }
        if(carry != 0) pointer.next = new ListNode(carry);
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        System.out.println(addTwoNumbers(l1, l2));
    }
}
