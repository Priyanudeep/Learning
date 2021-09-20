package assignmentProblems;

public class DListImpl_SinglePointer implements IList {

	int size;
	int currentIndex;
	DListNode current;

	public DListImpl_SinglePointer() {
		size = 0;
		currentIndex = -1;
	}

	private void goToIndex(int toIndex) {
		if (currentIndex <= toIndex)
			return;
		//for()
	}

	@Override
	public <T> boolean addFirst(T x) {
		DListNode temp = new DListNode();
		temp.value = x;
		if (size == 0) {
			current = temp;
		} else {
			goToIndex(0);
			temp.prev = current.prev;
			temp.next = current;
			current.prev = temp;
		}
		currentIndex = 0;
		size++;
		return true;
	}

	@Override
	public <T> boolean addLast(T x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> boolean add(int i, T x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> boolean removeFirst() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> boolean removeLast() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> boolean remove(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> boolean contains(T x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
