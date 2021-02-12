import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Task3 {
	public static int solve(int[] A, int X, int Y, int Z) {
		Map<Character, int[]> map = new HashMap<>();
		map.put('x', new int[] {X, 0});
		map.put('y', new int[] {Y, 0});
		map.put('z', new int[] {Z, 0});
		Queue<Map.Entry<Character, int[]>> minHeap = new PriorityQueue<>((a, b)->a.getValue()[0] == b.getValue()[0] ? a.getValue()[1] - b.getValue()[1] : a.getKey() - b.getKey());
		minHeap.addAll(map.entrySet());
		int[] res = new int[3];
		List<Map.Entry<Character, int[]>> lst = new ArrayList<>();
		for(int i=0;i<A.length;i++) {
			int cur = A[i];
			while(!minHeap.isEmpty()) {
				if(!minHeap.isEmpty() && minHeap.peek().getValue()[0] < cur) {
					lst.add(minHeap.poll());
					if(minHeap.isEmpty())
						return -1;
				}
				else {
					Map.Entry<Character, int[]> e = minHeap.poll();
					e.getValue()[0] -= cur;
					e.getValue()[1] += cur;
					lst.add(e);
					if(i == A.length-1)
						break;
					res[e.getKey() - 'x'] += cur;
					minHeap.addAll(lst);
					lst.clear();
					break;
				}
			}
		}
		return Math.max(res[0], Math.max(res[1], res[2]));
	}
}
