import java.util.*;

public class MergeKSortedList {
    public static ListNode mergeKSortedList(List<ListNode> kSortedLists) {
        if (Objects.isNull(kSortedLists) || kSortedLists.isEmpty()) return null;
        var result = new ListNode();
        var resultPointer = result;
        Queue<ListNode> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(node -> node.val));

        kSortedLists.stream()
                .filter(Objects::nonNull)
                .forEach(minHeap::offer);

        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            resultPointer.next = new ListNode(min.val);
            resultPointer = resultPointer.next;
            if (!Objects.isNull(min.next)) minHeap.offer(min.next);
        }
        return result.next;
    }

    public static void main(String[] args) {
        List<ListNode> kSortedLists = new ArrayList<>();
        ListNode current = new ListNode(0);
        for(int x=1; x < 20; x++) {
            if(x%3 == 0) {
                kSortedLists.add(current);
                current = new ListNode();
            } else {
                current.next = new ListNode(x);
                current = current.next;
            }
        }
        System.out.println(mergeKSortedList(kSortedLists));
    }
}
