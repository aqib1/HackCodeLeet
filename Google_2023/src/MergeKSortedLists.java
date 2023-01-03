import java.util.*;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] kSortedLists) {
        if(Objects.isNull(kSortedLists)) return null;
        ListNode merged = new ListNode();
        Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        Arrays.stream(kSortedLists)
                .filter(Objects::nonNull)
                .forEach(minHeap::offer);

        ListNode pointer = merged;
        while(!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            pointer.next = new ListNode(minNode.val);
            pointer = pointer.next;
            if(!Objects.isNull(minNode.next)) minHeap.offer(minNode.next);
        }

        return merged.next;
    }
}
