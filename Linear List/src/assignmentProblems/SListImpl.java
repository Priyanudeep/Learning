package assignmentProblems;

public class SListImpl implements IList {

	int size;
	SListNode head;

	SListImpl() {
		head = new SListNode();
		head.next = head;
		size = 0;
	}

	@Override
	public <T> boolean addFirst(T x) {
		SListNode temp = new SListNode<T>();
		temp.value = x;
		temp.next = head.next;
		head.next = temp;
		++size;
		return true;
	}

	@Override
	public <T> boolean addLast(T x) {
		boolean isLastNode = false;
		SListNode current = head;
		while (!isLastNode) {
			current = current.next;
			if (current.next == head) {
				isLastNode = true;
				SListNode temp = new SListNode();
				temp.next = head;
				current.next = temp;
				temp.value = x;
			}
		}
		++size;
		return true;
	}

	@Override
	public <T> boolean add(int i, T x) {
		if (i >= size || i < 0)
			return false;
		SListNode current = head;
		for (int j = 0; j < i; ++j)
			current = current.next;
		SListNode temp = new SListNode();
		temp.value = x;
		temp.next = current.next;
		current.next = temp;
		++size;
		return true;
	}

	@Override
	public <T> boolean removeFirst() {
		if (size == 0)
			return false;
		SListNode temp = head.next;
		head.next = temp.next;
		temp.next = null;
		temp = null;
		--size;
		return true;
	}

	@Override
	public <T> boolean removeLast() {
		if (size == 0)
			return false;
		SListNode current = head.next;
		for (int i = 0; i < size - 1; ++i)
			current = current.next;
		var temp = current.next;
		current.next = temp.next;
		temp.next = null;
		temp = null;
		--size;
		return true;
	}

	@Override
	public <T> boolean remove(int i) {
		if (size == 0 || i >= size)
			return false;
		SListNode current = head;
		for (int j = 0; j < i; ++j)
			current = current.next;
		var temp = current.next;
		current.next = temp.next;
		temp.next = null;
		temp = null;
		--size;
		return true;
	}

	@Override
	public void display() {
		SListNode current = head;
		for (int i = 0; i < size; ++i) {
			current = current.next;
			System.out.print(current.value + " ");
		}
		System.out.println();
	}

	@Override
	public <T> boolean contains(T x) {
		var current = head.next;
		for (int i = 0; i < size; ++i)
			if (current.value == x)
				return true;
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	public void myFunction() {
		SListNode current = head.next;
		SListNode temp;
		while (size > 2) {
			if (current.next == head)
				current = head;
			else if (current == head)
				current = head.next;
			temp = current.next;
			current.next = temp.next;
			temp = null;
			current = current.next;
			--size;
			display();
		}
	}
}
