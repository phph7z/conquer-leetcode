// @desc-start
// Design a HashSet without using any built-in hash table libraries.
// To be specific, your design should include these functions:
// 
// add(value): Insert a value into the HashSet. 
// contains(value) : Return whether the value exists in the HashSet or not.
// remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
// 
// 
// Example:
// 
// MyHashSet hashSet = new MyHashSet();
// hashSet.add(1);         
// hashSet.add(2);         
// hashSet.contains(1);    // returns true
// hashSet.contains(3);    // returns false (not found)
// hashSet.add(2);          
// hashSet.contains(2);    // returns true
// hashSet.remove(2);          
// hashSet.contains(2);    // returns false (already removed)
// 
// 
// Note:
// 
// All values will be in the range of [0, 1000000].
// The number of operations will be in the range of [1, 10000].
// Please do not use the built-in HashSet library.
// 
// 
// @desc-end


// @code-start
class MyHashSet {
	private static final int DEFAULT_CAP = 31;
	private LinkedList<Integer>[] data;
	private int cap;
	private int size;
    /** Initialize your data structure here. */
    public MyHashSet() {
		data = new LinkedList[DEFAULT_CAP];
		for(int i =0; i < DEFAULT_CAP;i++) {
			data[i] = new LinkedList<>();
		}
		cap = DEFAULT_CAP;
		size = 0;
    }

	private int hash(int key) {
		return key % cap;
	}
    
    public void add(int key) {
		int hash = hash(key);
		LinkedList<Integer> l = data[hash];
		if(l.isEmpty()) {
			l.add(key);
		} else {
			for(int v : l) {
				if(v == key)
					return;
			}
			l.add(key);
		}
    }
    
    public void remove(int key) {
		int hash = hash(key);
		LinkedList<Integer> l = data[hash];
		for(int v : l) {
			if (v == key) {
				l.remove(new Integer(key));
				break;
			}
		}
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
		int hash = hash(key);
		LinkedList<Integer> l = data[hash];
		for(int v : l) {
			if(v == key) {
				return true;
			}
		}
		return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @code-end
