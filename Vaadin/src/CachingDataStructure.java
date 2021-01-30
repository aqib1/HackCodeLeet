
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

interface TimeProvider {
	long getMillis();
}

public class CachingDataStructure {
	private int maxSize;
	private TimeProvider timeProvider;
	private Queue<CacheData> heap;

	public CachingDataStructure(TimeProvider timeProvider, int maxSize) {
		if (timeProvider == null)
			throw new IllegalArgumentException();

		this.timeProvider = timeProvider;
		this.maxSize = maxSize;

		heap = new PriorityQueue<>(maxSize,
				(p, q) -> Long.compare(p.getTimeToLeaveInMilliseconds(), q.getTimeToLeaveInMilliseconds()));
	}

	public void put(String key, String value, long timeToLeaveInMilliseconds) {
		if (key == null || value == null || timeToLeaveInMilliseconds <= 0)
			throw new IllegalArgumentException();
		removeAtLimitExceed();
		if (!this.heap.isEmpty() && ifKeyExists(key) == null
				&& timeToLeaveInMilliseconds < this.heap.peek().getTimeToLeaveInMilliseconds()) {
			return;
		}

		long actualSize = timeToLeaveInMilliseconds + this.timeProvider.getMillis();

		if (this.heap.size() <= this.maxSize) {
			if (this.heap.size() == this.maxSize) {
				CacheData data = this.heap.poll();
				data.setValue(value);
				data.setActualLeave(actualSize);
				data.setTimeToLeaveInMilliseconds(timeToLeaveInMilliseconds);
			} else {
				CacheData data = ifKeyExists(key);
				if (data != null) {
					heap.remove(data);
					heap.add(new CacheData(key, value, timeToLeaveInMilliseconds, actualSize));
				} else {
					heap.add(new CacheData(key, value, timeToLeaveInMilliseconds, actualSize));
				}
			}
		}
	}

	public void removeAtLimitExceed() {
		if (!heap.isEmpty()) {
			if (this.timeProvider.getMillis() >= heap.peek().actualLeave) {
				heap.poll();
			}
		}
	}

	private CacheData ifKeyExists(String key) {
		return this.heap.stream().filter(x -> x.key.equals(key)).findFirst().orElse(null);
	}

	public Optional<String> get(String key) {
		if (key == null)
			throw new IllegalArgumentException();
		removeAtLimitExceed();
		CacheData data = ifKeyExists(key);
		if (data == null)
			return Optional.empty();
		return Optional.of(data.value);
	}

	public int size() {
		removeAtLimitExceed();
		return heap.size();
	}

	class CacheData {
		private String key;
		private String value;
		long timeToLeaveInMilliseconds;
		long actualLeave;

		public CacheData() {
		}

		public CacheData(String key, String value, long timeToLeaveInMilliseconds, long actualLeave) {
			this.key = key;
			this.value = value;
			this.timeToLeaveInMilliseconds = timeToLeaveInMilliseconds;
			this.actualLeave = actualLeave;
		}

		public long getActualLeave() {
			return actualLeave;
		}

		public void setActualLeave(long actualLeave) {
			this.actualLeave = actualLeave;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public long getTimeToLeaveInMilliseconds() {
			return timeToLeaveInMilliseconds;
		}

		public void setTimeToLeaveInMilliseconds(long timeToLeaveInMilliseconds) {
			this.timeToLeaveInMilliseconds = timeToLeaveInMilliseconds;
		}
	}

}
