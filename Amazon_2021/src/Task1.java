import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
public class Task1 {
	 public static List<Integer> reassignedPriorities(List<Integer> priorities) {
		 if(Objects.isNull(priorities) || priorities.isEmpty()) 
			 return new ArrayList<Integer>();
		 Map<Integer, Integer> numberByPriority = new HashMap<>();
		 Queue<Integer> minHeap = new PriorityQueue<Integer>();
		 priorities.forEach(value -> minHeap.offer(value));
		 AtomicInteger priority = new AtomicInteger(0);
		
		 while(!minHeap.isEmpty()) {
			 int value = minHeap.poll();
			 if(!numberByPriority.containsKey(value)) {
				 numberByPriority.put(value, priority.incrementAndGet());
			 }
		 }
		 List<Integer> reassignedPriorities = new ArrayList<Integer>();
		 priorities.forEach(value -> 
			 reassignedPriorities.add(numberByPriority.get(value)));
		 return reassignedPriorities;
	 }
 public static void main(String[] args) {
	System.out.println(reassignedPriorities(Arrays.asList(2, 19, 53, 12, 3)));
}
}
