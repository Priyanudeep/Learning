package assignmentProblems;

public class DListNode <T>{
	DListNode prev;
	DListNode next;
	T value;
	
	public DListNode() {
		prev = next = this;
	}
	public DListNode(T i) {
		value = i;
	}
}
