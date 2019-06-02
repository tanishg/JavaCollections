public class MyArrayList<T> implements Iterable<T> {

	private static final int DEFAUL_CAP = 10;
	private static int capacity = DEFAUL_CAP;// intially it is set to default
	private int size = 0;
	Object arr[] = new Object[DEFAUL_CAP];

	public boolean add(T t) {
		arr = grow(arr, size);
		arr[size++] = t;
		return true;
	}

	public boolean add(T t, int index) {
		arr = grow(arr, size);
		if (index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if (index == size) {
			arr[size++] = t;
		} else if (index < size)
			arr[index] = t;
		return true;
	}

	public T get(int index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return (T) arr[index];
	}

	private Object[] grow(Object[] objects, int size) {
		int len = objects.length;
		int ratio = (len * 75) / 100;
		Object[] objects2;
		if (size >= ratio) {
			// grow the capacity by 50%
			capacity = capacity + (capacity * 50) / 100;
			objects2 = new Object[capacity];
			copy(objects, objects2);
			objects = null;// ready to garbage collector
		} else {
			objects2 = objects;
		}
		return objects2;
	}

	private void copy(Object[] objects, Object[] objects2) {
		for (int i = 0; i < objects.length; i++) {
			objects2[i] = objects[i];
		}
	}

	public int length() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyArrInterate();
	}

	private class MyArrInterate implements Iterator<T> {
	
    private int iteratSize = 0;

		@Override
		public boolean hasNext() {
			return arr[iteratSize] != null;
		}

		@Override
		public T next() {
			return (T) arr[iteratSize++];
		}
	}
}
