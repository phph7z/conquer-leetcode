// @desc-start
// Implement a trie with insert, search, and startsWith methods.
// Example:
// 
// Trie trie = new Trie();
// 
// trie.insert("apple");
// trie.search("apple");   // returns true
// trie.search("app");     // returns false
// trie.startsWith("app"); // returns true
// trie.insert("app");   
// trie.search("app");     // returns true
// 
// Note:
// 
// You may assume that all inputs are consist of lowercase letters a-z.
// All inputs are guaranteed to be non-empty strings.
// 
// 
// @desc-end


// @code-start
class Trie {

	private static class Node {
		public char ch;
		public boolean end;
		public Node[] children;
		public Node(char ch) {
			this.ch = ch;
			children = new Node[26];
			end = false;
		}
	}

	private Node head;

    /** Initialize your data structure here. */
    public Trie() {
		head = new Node('#');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
		char[] arr = word.toCharArray();
		Node tmp = head;
		for(int i = 0; i < arr.length; i++) {
			int j = arr[i] - 'a';
			if(tmp.children[j] == null) {
				Node n = new Node(arr[i]);
				tmp.children[j] = n;
			}
			if(i == arr.length - 1) {
				tmp.children[j].end = true;
			}
			tmp = tmp.children[j];
		}
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
		char[] arr = word.toCharArray();
		Node tmp = head;
		for(int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			int j = ch - 'a';
			if(tmp.children[j] == null) {
				return false;
			}
			if(i == arr.length - 1 && tmp.children[j].end) {
				return true;
			}
			tmp = tmp.children[j];
		}
		return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
		char[] arr = prefix.toCharArray();
		Node tmp = head;
		for(int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			int j = ch - 'a';
			if(tmp.children[j] == null) {
				return false;
			}
			tmp = tmp.children[j];
		}
		return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @code-end
