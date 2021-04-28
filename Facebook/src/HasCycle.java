import java.util.Objects;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class HasCycle {
	public boolean hasCycle(ListNode head) {
		if(Objects.isNull(head) || Objects.isNull(head.next))
			return Boolean.FALSE;
		
		ListNode tortoise = head;
		ListNode hare = head.next;
		while(!Objects.isNull(hare) && !Objects.isNull(hare.next)) {
			if(tortoise == hare) 
				return Boolean.TRUE;
			tortoise = tortoise.next;
			hare = hare.next.next;
		}
		
		return Boolean.FALSE;
		
		
	}
}
