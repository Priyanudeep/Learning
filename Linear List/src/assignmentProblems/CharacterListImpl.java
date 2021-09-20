package assignmentProblems;

public class CharacterListImpl implements CharacterList {

	private class Node {
		Node prev;
		Node next;
		char value;
	}

	private int size;

	public Node head;

	public CharacterListImpl() {
		size = 0;
		head = new Node();
		head.prev = null;
		head.next = null;
		head.value = '\0';
	}

	@Override
	public boolean addCharacterAtIndex(char c, int index) {
		// TODO Auto-generated method stub
		if (index >= size) {
			return false;
		}

		return true;
	}

	@Override
	public void displayCharacterList() {
		// TODO Auto-generated method stub
		System.out.println("Hello World");

	}

	@Override
	public boolean addCharacterAtFirstIndex(char c) {
		Node temp = new Node();
		temp.value = c;
		temp.next = head.next;
		head.next = temp;
		temp.prev = head;
		++size;
		return true;
	}

	@Override
	public boolean addCharacterAtLastIndex(char c) {
		// TODO Auto-generated method stub
		return false;
	}

}
