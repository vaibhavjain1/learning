package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Get: if cache contains object return it and make it most recently used
 * 			a. check if it is most recently used return from there itself
 * 			b. check if it least recently used
 * 			c. else object is in middle of linked list.
 * 		if not then return null
 * 
 * Put: if cache does not contains
 * 			a. if cache is full remove least recently used and put object in cache
 * 			b. if cache is not full put object in cache
 * 		Make object as most recently used
 */

class LRUNode{
	Integer key;
	String value;
	LRUNode previous;
	LRUNode next;
	public LRUNode(Integer key, String value) {
		this.key = key;
		this.value = value;
		this.previous = null;
		this.next = null;
	}
}

class LRUMCache{
	// Creating cache with key as same 
	Map<Integer, LRUNode> cache = new HashMap<>();
	static int MAX_SIZE = 4;
	LRUNode mostRecentlyUsed;
	LRUNode leastRecentlyUsed = mostRecentlyUsed;
	
	public String get(Integer key){
		LRUNode lruValue = cache.get(key);
		// if element not available in cache
		if(lruValue==null)
			return null;
		// if available
		else{
			// if node is most recently used
			if(lruValue.key==mostRecentlyUsed.key){
				return lruValue.value;
			}
			
			// if node is least recently used then remove it from there
			if(lruValue.key==leastRecentlyUsed.key){
				lruValue.next.previous = null;
				leastRecentlyUsed = leastRecentlyUsed.next;
				lruValue.next = null;
			}
				
			// 	if node is in middle then move previous and next nodes
			else{
				lruValue.previous.next = lruValue.next;
				lruValue.next.previous = lruValue.previous;
				lruValue.previous = null;
				lruValue.next = null;
			}
				
		}
		// Make node as most recently used
		lruValue.previous = mostRecentlyUsed;
		mostRecentlyUsed.next = lruValue;
		mostRecentlyUsed = lruValue;
		return lruValue.value;
	}
	
	public void put(Integer key, String value) {
		LRUNode lruNode = new LRUNode(key, value);
		if (!cache.containsKey(key)) {
			if (cache.size() == MAX_SIZE) {
				// Need to remove least recently used
				cache.remove(leastRecentlyUsed.key);
				leastRecentlyUsed = leastRecentlyUsed.next;
				leastRecentlyUsed.previous = null;
				cache.put(key, lruNode);

			} else {
				cache.put(key, lruNode);
				if (mostRecentlyUsed == null) {
					leastRecentlyUsed = lruNode;
					mostRecentlyUsed = lruNode;
				}
			}
		}
		// Making node as most recently used
		mostRecentlyUsed.next = lruNode;
		lruNode.previous = mostRecentlyUsed;
		mostRecentlyUsed = lruNode;
	}
	
	public void printCacheAndDoublyLinkedList(){
		System.out.println("Cache:");
		Set<Map.Entry<Integer, LRUNode>> currSet = cache.entrySet();
		for (Map.Entry<Integer, LRUNode> entry : currSet) {
			System.out.print(entry.getKey()+":"+entry.getValue().value+" ");
		}
		System.out.println("\nLinkedList:");
		LRUNode currNode = leastRecentlyUsed;
		while(currNode!=null){
			System.out.print(currNode.key+":"+currNode.value+" ");
			currNode = currNode.next;
		}
	}
}

public class LRUCacheManual {

	public static void main(String[] args) {
		LRUMCache obj = new LRUMCache();
		obj.put(1, "A");
		obj.put(2, "B");
		obj.put(3, "C");
		obj.put(4, "D");
		obj.printCacheAndDoublyLinkedList();
		System.out.println("Cache is full now");
		
		// Adding extra element when size is full
		System.out.println("\nInserting 5");
		obj.put(5, "E");
		obj.printCacheAndDoublyLinkedList();

		// Adding element which is already there
		System.out.println("\nInserting 3");
		obj.put(3, "C");
		obj.printCacheAndDoublyLinkedList();
		
		// Getting element which was least recently used
		System.out.println("\nGetting 2");
		System.out.println(obj.get(2));
		obj.printCacheAndDoublyLinkedList();
		
		// Getting element which was in average recently used
		System.out.println("\nGetting 4");
		System.out.println(obj.get(4));
		obj.printCacheAndDoublyLinkedList();
		
		// Getting element which was most recently used
		System.out.println("\nGetting 4");
		System.out.println(obj.get(4));
		obj.printCacheAndDoublyLinkedList();
	}

}
