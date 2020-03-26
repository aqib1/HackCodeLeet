import java.util.Arrays;

public class MinHeap {

	private Integer[] minHeap;
	private int capacity;
	private int heapSize;

	public MinHeap(int capacity) {
		this.capacity = capacity;
		minHeap = new Integer[this.capacity];
	}

	public void add(Integer value) {
		minHeap[heapSize++] = value;
		heapify(heapSize - 1);
	}

	// MIN heap
	private void heapify(int index) {
		if (index == 0)
			return;
		while (index >= 0 && minHeap[getParentIndex(index)] > minHeap[index]) {
			Integer parentValue = minHeap[getParentIndex(index)];
			minHeap[getParentIndex(index)] = minHeap[index];
			minHeap[index] = parentValue;
			index = getParentIndex(index);
		}
	}

	public Integer poll() {
		Integer value = minHeap[0];
		heapifyPoll();
		return value;
	}

	private void heapifyPoll() {
		Integer[] copy = minHeap;
		minHeap = new Integer[--heapSize];
		heapSize = 0;
		for (int x = 1; x < copy.length; x++)
			add(copy[x]);
	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

//	private int[] getChildIndexes(int current) {
//		return new int[] { current + current + 1, current + current + 2 };
//	}

	@Override
	public String toString() {
		return Arrays.toString(minHeap);
	}

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(7);
		minHeap.add(8);
		minHeap.add(4);
		minHeap.add(3);
		minHeap.add(2);
		minHeap.add(19);
		minHeap.add(15);
		minHeap.add(1);

		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
	}
}
