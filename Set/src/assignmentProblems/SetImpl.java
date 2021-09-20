package assignmentProblems;

public class SetImpl implements ISet {

	// We need number of buckets.
	private int size;
	// private ListNode head;
	private ListNode[] buckets;
	private static final int THRESHOLD = 10;

	public SetImpl() {
		// ListNode[] nodeArray = new ListNode[10];
		buckets = new ListNode[11];
		for (int i = 0; i < buckets.length; ++i)
			buckets[i] = new ListNode();
	}

	//TC: O(1)am
	@Override
	public boolean add(int x) {
		if (contains(x))
			return false;
		if (size / buckets.length > THRESHOLD)
			rehash();
		int index = hash(x, buckets.length);
		var temp = new ListNode(x);
		temp.next = buckets[index].next;
		buckets[index].next = temp;
		++size;
		return true;
	}

	private void rehash() {
		var buckets_new = new ListNode[buckets.length * 2];
		for (int i = 0; i < buckets_new.length; ++i)
			buckets_new[i] = new ListNode();

		ListNode temp;
		for (int i = 0; i < buckets.length; ++i) {
			for (ListNode current = buckets[i].next; current != null; current = temp) {
				int index = hash(current.data, buckets_new.length);
				temp = current.next;
				current.next = buckets_new[index].next;
				buckets_new[index].next = current;
			}
		}
		buckets = buckets_new;
	}

	//TC: O(1)am
	@Override
	public boolean remove(int x) {
		int index = hash(x, buckets.length);
		for (ListNode current = buckets[index]; current.next != null; current = current.next)
			if (current.next.data == x) {
				current.next = current.next.next;
				--size;
				return true;
			}
		return false;
	}

	//TC: Theta(n)
	@Override
	public void display() {
		for (int i = 0; i < buckets.length; ++i) {
			System.out.print("bucket-" + i + ": ");
			for (ListNode current = buckets[i].next; current != null; current = current.next)
				System.out.print(current.data + " ");
			System.out.println();
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	//TC: O(1)am
	@Override
	public boolean contains(int x) {
		int index = hash(x, buckets.length);
		for (ListNode current = buckets[index].next; current != null; current = current.next)
			if (current.data == x)
				return true;
		return false;
	}

	private int hash(int x, int numberOfBuckets) {
		return x % numberOfBuckets;
	}

}
