import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this(val, null);
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" ").append(val);
        ListNode nextPointer = this.next;
        while(!Objects.isNull(nextPointer)) {
            sb.append(" ").append(nextPointer.val);
            nextPointer = nextPointer.next;
        }
        return sb.append("\n").toString();
    }
}
