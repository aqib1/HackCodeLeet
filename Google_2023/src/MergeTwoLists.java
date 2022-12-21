import java.util.*;

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

    // Space complexity is O(KxN) where K x N = total number of nodes.
    // Time complexity is OKxN(LogK)
    public ListNode mergeKLists(ListNode[] lists) {
        if(Objects.isNull(lists) || lists.length == 0) return null;
        var merge = new ListNode();
        var result = merge;
        // default implementation is already min heap
        Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        Arrays.stream(lists)
                .filter(Objects::nonNull)
                .forEach(minHeap::offer);

        while(!minHeap.isEmpty()) {
            ListNode current = minHeap.remove();
            merge.next = current;
            merge = merge.next;
            if (!Objects.isNull(current.next)) {
                minHeap.offer(current.next);
            }

        }

        return result.next;
    }

}
