package tree;

public class ListNodeToBST {

	public ListNode mid(ListNode head) {
		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(prev != null)
			prev.next = null;
		
		return slow;
	}
	
	public TreeNode sortedListToBST(ListNode head) {
		
		if(head == null)
			return null;
		
		ListNode mid = mid(head);
		
		TreeNode node = new TreeNode(mid.val);
		
		if(mid == head)
			return node;
		
		node.left = sortedListToBST(head);
		node.right = sortedListToBST(mid.next);
		return node;
	}

}
