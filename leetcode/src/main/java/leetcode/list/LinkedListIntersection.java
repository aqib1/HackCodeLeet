package leetcode.list;

import java.util.Objects;

public class LinkedListIntersection {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (Objects.isNull(headA) || Objects.isNull(headB))
			return null;

		ListNode pointA = headA, pointB = headB;

		while (pointA != pointB) {
			pointA = pointA != null ? pointA.next : headB;
			pointB = pointB != null ? pointB.next : headA;
		}

		return pointA;

	}
}
