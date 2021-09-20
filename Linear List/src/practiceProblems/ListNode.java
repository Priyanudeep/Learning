package practiceProblems;

public class ListNode {
	int value;
	ListNode next;
	int val;

	public ListNode() {

	}

	public ListNode(int value) {
		this.value = value;
		this.val = value;
	}

	public ListNode createList(int[] arr) {
		ListNode head = new ListNode(arr[0]);
		ListNode current = head;
		for (int i = 1; i < arr.length; ++i) {
			ListNode temp = new ListNode(arr[i]);
			current.next = temp;
			current = current.next;
		}
		return head;
	}

	public void printList(ListNode node) {
		if(node == null) {
			System.out.println("Null/Empty list");
			return;
		}
		System.out.println();
		while (node != null) {
			System.out.print(node.value + "->");
			node = node.next;
		}
	}
}
