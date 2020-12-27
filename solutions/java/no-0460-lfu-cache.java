// @desc-start
// Design and implement a data structure for Least Frequently Used (LFU) cache.
// Implement the LFUCache class:
// 
// LFUCache(int capacity) Initializes the object with the capacity of the data structure.
// int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
// void put(int key, int value) Sets or inserts the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be evicted.
// 
// Notice that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
//  
// Example 1:
// 
// Input
// ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
// 
// Explanation
// LFUCache lfu = new LFUCache(2);
// lfu.put(1, 1);
// lfu.put(2, 2);
// lfu.get(1);      // return 1
// lfu.put(3, 3);   // evicts key 2
// lfu.get(2);      // return -1 (not found)
// lfu.get(3);      // return 3
// lfu.put(4, 4);   // evicts key 1.
// lfu.get(1);      // return -1 (not found)
// lfu.get(3);      // return 3
// lfu.get(4);      // return 4
// 
//  
// Constraints:
// 
// 0 <= capacity, key, value <= 104
// At most 105 calls will be made to get and put.
// 
//  
// Follow up: Could you do both operations in O(1) time complexity? 
// @desc-end


// @code-start
class LFUCache {
	private int cap;
	private int minFreq;
	private Map<Integer,Integer> key2valMap;
	private Map<Integer,Integer> key2freqMap;
	private Map<Integer,LinkedHashSet<Integer>> freq2keyMap;

    public LFUCache(int capacity) {
		cap = capacity;
		minFreq = 0;
		key2valMap = new HashMap<>();
		key2freqMap = new HashMap<>();
		freq2keyMap = new HashMap<>();
    }
    
    public int get(int key) {
		if(key2valMap.containsKey(key)) {
			int freq = key2freqMap.get(key);
			increseFreq(key);
			return key2valMap.get(key);
		} else {
			return -1;
		}
    }

	private void increseFreq(int key) {
		int freq = key2freqMap.get(key);
		key2freqMap.put(key, freq + 1);
		Set<Integer> s = freq2keyMap.get(freq);
		s.remove(key);
		freq2keyMap.putIfAbsent(freq + 1, new LinkedHashSet<>());
		freq2keyMap.get(freq + 1).add(key);
		if(minFreq == freq && freq2keyMap.get(freq).isEmpty()) {
			minFreq += 1;
		}
	}

	private void removeMinFreqKey() {
		Set<Integer> s = freq2keyMap.get(minFreq);
		int key = s.iterator().next();
		s.remove(key);
		key2valMap.remove(key);
		key2freqMap.remove(key);
	}
    
    public void put(int key, int value) {
		if(cap <= 0) {
			return;
		}
		if(key2valMap.containsKey(key)) {
			key2valMap.put(key, value);
			increseFreq(key);
			return;
		}
		if(key2valMap.size() == cap) {
			// remove 
			removeMinFreqKey();
		}
		key2valMap.put(key, value);
		key2freqMap.put(key, 1);
		freq2keyMap.putIfAbsent(1, new LinkedHashSet<>());
		freq2keyMap.get(1).add(key);
		minFreq = 1;
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @code-end
