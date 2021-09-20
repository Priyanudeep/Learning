package assignmentProblems;

public class DListImpl implements IList {

	DListNode head;
	int size = 0;

	DListImpl() {
		head = new DListNode();
		size = 0;
		head.next = head;
		head.prev = head;
	}

	@Override
	public <T> boolean addFirst(T x) {
		DListNode temp = new DListNode();
		temp.next = head.next;
		temp.prev = head;
		temp.value = x;
		head.next.prev = temp;
		head.next = temp;
		++size;
		return true;
	}

	@Override
	public <T> boolean addLast(T x) {
		DListNode temp = new DListNode();
		temp.next = head;
		temp.prev = head.prev;
		temp.value = x;
		head.prev.next = temp;
		head.prev = temp;
		++size;
		return true;
	}

	@Override
	public <T> boolean add(int i, T x) {
		DListNode current = head;
		DListNode temp = new DListNode();
		for (int j = 0; j < i; ++j)
			current = current.next;
		temp.prev = current;
		temp.value = x;
		temp.next = current.next;
		current.next = temp;
		++size;
		return true;
	}

	@Override
	public boolean removeFirst() {
		if (size == 0)
			return false;
		DListNode current = head.next;
		head.next = current.next;
		current.next.prev = head;
		current = null;
		--size;
		return true;
	}

	@Override
	public boolean removeLast() {
		if (size == 0)
			return false;
		DListNode current = head.prev;
		current.prev.next = head;
		head.prev = current.prev;
		current = null;
		--size;
		return true;
	}

	@Override
	public boolean remove(int i) {
		if (size == 0)
			return false;
		DListNode current = head;
		for (int j = 0; j <= i; ++j)
			current = current.next;
		current.prev.next = current.next;
		current.next.prev = current.prev;
		current = null;
		--size;
		return true;
	}

	@Override
	public void display() {
		DListNode current = head;
		for (int i = 0; i < size; ++i) {
			System.out.print(current.next.value + " ");
			current = current.next;
		}
		System.out.println();
	}

	@Override
	public <T> boolean contains(T x) {
		DListNode current = head;
		for (int i = 0; i < size; current = current.next)
			if (current.value == x)
				return true;
		return false;
	}

	@Override
	public int size() {
		return size;
	}
}
