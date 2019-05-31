public class MyLinkedList<T> implements Iterable<T> {

	T data;
	MyLinkedList<T> next;
	private int size;
	private MyLinkedList<T> head;
	private MyLinkedList<T> tail;
	private MyLinkedList<T> traverse;

	private MyLinkedList<T> createNode(T data) {
		MyLinkedList<T> newNode = new MyLinkedList<T>();
		newNode.data = data;
		return newNode;
	}

	void add(T data) {
		if (head == null) {
			head = this;
		}
		if (tail == null && size == 0) {
			tail = this;
		}
		size++;
		tail.next = createNode(data);
		tail = tail.next;
	}

	public T get(int index) {
		if (traverse == null) {
			traverse = head;
		}
		for (int i = 1; i <= index; i++) {
			traverse = traverse.next;
		}
		return traverse.data;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyListIterate();
	}

	private class MyListIterate implements Iterator<T> {

		MyLinkedList<T> itera;

		@Override
		public boolean hasNext() {
			if (itera == null) {
				itera = head;
			}
			itera = itera.next;
			return itera != null;
		}

		@Override
		public T next() {
			return itera.data;
		}
	}

	public int size() {
		return size;
	}
}
