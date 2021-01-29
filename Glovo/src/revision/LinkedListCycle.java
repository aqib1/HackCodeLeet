package revision;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedListCycle {
	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static boolean hasCycleLessIteration(ListNode node) {
		Set<ListNode> set = new HashSet<>();
		while(node != null) {
			if(set.contains(node))
				return true;
			set.add(node);
			node = node.next;
		}
		return false;
	} 
	
	//O(n)
	public static boolean hasCycle(ListNode node) {
		if(node == null || node.next == null)
			return false;
		ListNode tortoise = node.next, hare = node.next.next;
		while(!Objects.isNull(tortoise) && !Objects.isNull(hare)) {
			if(tortoise == hare)
				return true;
			else {
				tortoise = tortoise.next;
				hare = hare.next.next;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		ListNode li = new ListNode(1);
		li.next = new ListNode(2);
		li.next.next = li.next;
		System.out.println(hasCycleLessIteration(li));
	}
}
