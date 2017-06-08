package collections;

class Entry {
	String key;
	int value;
	Entry next;

	Entry(String key, int value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

	int getValue() {
		return value;
	}

}

public class HashMapImpl {

	private static final int SIZE = 16;
	Entry[] entry = new Entry[SIZE];

	private int getBucketNumber(int hash) {
		return hash & (SIZE - 1);
	}

	public void put(String key, int value) {
		int bucket = getBucketNumber(key.hashCode());
		Entry currEntry;
		for (currEntry = entry[bucket]; currEntry != null; currEntry = currEntry.next) {
			if (currEntry.key.equals(key)) {
				currEntry.value = value;
				return;
			}
		}
		Entry entryInOldBucket = new Entry(key, value);
		entryInOldBucket.next = entry[bucket];
		entry[bucket] = entryInOldBucket;
	}

	public int get(String key) {
		int bucketNumber = getBucketNumber(key.hashCode());
		Entry currEntry = entry[bucketNumber];
		while (currEntry.next != null) {
			if (currEntry.key.equals(key))
				return currEntry.value;
		}
		return 0;
	}

	public static void main(String[] args) {
		HashMapImpl impl = new HashMapImpl();
		impl.put("one", 1);
		impl.put("two", 2);
		impl.put("three", 3);
		impl.put("four", 4);
		System.out.println(impl.get("four"));
	}

}