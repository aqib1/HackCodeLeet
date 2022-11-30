import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DSQueue {
    public static void main(String[] args) {
        Queue<Integer> fifoQueue = new LinkedList<>();
        // offer call add internally in LinkedList which
        // add element is linked list manner
        fifoQueue.offer(5);
        fifoQueue.offer(2);
        fifoQueue.offer(3);
        System.out.println(fifoQueue);
        System.out.println(fifoQueue.poll());
        System.out.println(fifoQueue);
        System.out.println(fifoQueue.peek());
        System.out.println(fifoQueue);

        Queue<Integer> priorityQueue = new PriorityQueue<>();
        // PriorityQueue add internally call offer, which add
        // elements in priority manner (by default its min heap)
        // Insertion time complexity is O(Log N)
        // For K elements insertion time is O(K(Log N))
        priorityQueue.add(5);
        priorityQueue.add(4);
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(1);

        // min heap will sort data in ascending order
        System.out.println(priorityQueue);
        // it removes first element from min heap
        // as elements are sorted, we will get 1 as first output.
        // remove and poll give us first element of heap
        // it also remove and shift other elements to maintain heap
        // structure that why time complexity is O(Log N)
        // and for removing K elements it will O(k(log N))
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.poll());

        // other methods like peek or size are O(1).
    }
}
