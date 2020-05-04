package challenges;

import java.util.Objects;

public class NodeWhereCycleBegins {
	
	public static void main(String[] args) {
		
	}
	
	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}
	// Floyd's hare and tortoise algorithm O(n)

	public ListNode detectCycle(ListNode root) {
		if (Objects.isNull(root) || Objects.isNull(root.next))
			return null;
		ListNode tortoise = root.next, hare = root.next.next;
		while (!Objects.isNull(hare) && !Objects.isNull(hare.next)) {
			if (tortoise == hare)
				break;
			tortoise = tortoise.next;
			hare = hare.next.next;
		}
		if (tortoise != hare) {
			return null;
		}

		tortoise = root;
		while (tortoise != hare) {
			tortoise = tortoise.next;
			hare = hare.next;
		}
		return tortoise;
	}
}
