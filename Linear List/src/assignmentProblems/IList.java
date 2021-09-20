package assignmentProblems;

public interface IList {
	public <T> boolean addFirst(T x);
	public <T> boolean addLast(T x);
	public <T> boolean add(int i, T x);
	public <T> boolean removeFirst();
	public <T> boolean removeLast();
	public <T> boolean remove(int i);
	public void display();
	public <T>boolean contains(T x);
	public int size();
}
