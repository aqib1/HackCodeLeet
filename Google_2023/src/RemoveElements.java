public class RemoveElements {

//    Time complexity O(N) space O(1)
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;

        ListNode previous = head, next = head.next;

        while(next != null) {
            if(next.val == val) {
                previous.next = next.next;
            } else {
                previous = previous.next;
            }
            next = next.next;
        }

        if(head.val == val) head = head.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        System.out.println(removeElements(head, 1));
    }
}
