import java.util.Objects;

class ListNode {
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
}

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(Objects.isNull(list1) && Objects.isNull(list2)) return null;

        ListNode result = new ListNode();
        ListNode resultPointer = result;
        while(!Objects.isNull(list1) && !Objects.isNull(list2)) {
            if(list1.val <= list2.val) {
                resultPointer.next = list1;
                list1 = list1.next;
            } else {
                resultPointer.next = list2;
                list2 = list2.next;
            }
            resultPointer = resultPointer.next;
        }

        if(!Objects.isNull(list1)) {
            resultPointer.next = list1;
        }

        if(!Objects.isNull(list2)) {
            resultPointer.next = list2;
        }

        return result.next;
    }
}
