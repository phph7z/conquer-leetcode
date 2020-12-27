// @desc-start
// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
// Implement the LRUCache class:
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// 
// Follow up:
// Could you do get and put in O(1) time complexity?
//  
// Example 1:
// 
// Input
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]
// 
// Explanation
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4
// 
//  
// Constraints:
// 
// 1 <= capacity <= 3000
// 0 <= key <= 3000
// 0 <= value <= 104
// At most 3 * 104 calls will be made to get and put.
// 
// 
// @desc-end


// @code-start
class LRUCache {

	private static class Node {
		public int key;
		public int val;
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	private int cap;
	private LinkedList<Node> data;
	private HashMap<Integer, Node> key2node;

    public LRUCache(int capacity) {
		cap = capacity;
		data = new LinkedList<>();
		key2node = new HashMap<>();
    }
    
	// remove O(n)
    public int get(int key) {
		if(key2node.containsKey(key)) {
			Node n = key2node.get(key);
			data.remove(n);
			data.add(n);
			return n.val;
		} else {
			return -1;
		}
    }

	private boolean isFull() {
		return key2node.size() == cap;
	}
    
    public void put(int key, int value) {
		if(key2node.containsKey(key)) {
			Node n = key2node.get(key);
			n.val = value;
			data.remove(n);
			data.add(n);
			return;
		}
		if(isFull()) {
			// remove oldest entry
			Node n = data.removeFirst();
			key2node.remove(n.key);
		}
		Node n = new Node(key, value);
		data.add(n);
		key2node.put(key, n);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @code-end
