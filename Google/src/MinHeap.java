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
		
		
	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(minHeap);
	}

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(5);
		minHeap.add(8);
		minHeap.add(4);
		minHeap.add(3);
		minHeap.add(1);
		minHeap.add(2);
		
		System.out.println(minHeap);
	}
}
