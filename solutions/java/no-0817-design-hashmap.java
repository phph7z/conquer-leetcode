// @desc-start
// Design a HashMap without using any built-in hash table libraries.
// To be specific, your design should include these functions:
// 
// put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
// get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
// remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
// 
// 
// Example:
// 
// MyHashMap hashMap = new MyHashMap();
// hashMap.put(1, 1);          
// hashMap.put(2, 2);         
// hashMap.get(1);            // returns 1
// hashMap.get(3);            // returns -1 (not found)
// hashMap.put(2, 1);          // update the existing value
// hashMap.get(2);            // returns 1 
// hashMap.remove(2);          // remove the mapping for 2
// hashMap.get(2);            // returns -1 (not found) 
// 
// 
// Note:
// 
// All keys and values will be in the range of [0, 1000000].
// The number of operations will be in the range of [1, 10000].
// Please do not use the built-in HashMap library.
// 
// 
// @desc-end


// @code-start
class MyHashMap {

	private static final int DEFAULT_CAP = 31;
	private static class Node {
		public int key;
		public int val;
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
	private LinkedList<Node>[] data;

    /** Initialize your data structure here. */
    public MyHashMap() {
		data = new LinkedList[DEFAULT_CAP];
		for(int i = 0; i < DEFAULT_CAP; i++) {
			data[i] = new LinkedList<Node>();
		}
    }

	private int hash(int value) {
		return value % DEFAULT_CAP;
	}
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
		int hash = hash(key);
		LinkedList<Node> l = data[hash];
		for(Node n : l) {
			if(n.key == key) {
				n.val = value;
				return;
			}
		}
		Node n = new Node(key, value);
		l.add(n);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
		int hash = hash(key);
		LinkedList<Node> l = data[hash];
		for(Node n : l) {
			if(n.key == key) {
				return n.val;
			}
		}
		return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
		int hash = hash(key);
		LinkedList<Node> l = data[hash];
		Node d = null;
		for(Node n : l) {
			if(n.key == key) {
				d = n;
				break;
			}
		}
		if(d != null) {
			l.remove(d);
		}
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @code-end
