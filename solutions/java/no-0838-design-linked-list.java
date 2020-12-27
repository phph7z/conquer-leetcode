// @desc-start
// Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
// A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
// If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
// Implement the MyLinkedList class:
// 
// MyLinkedList() Initializes the MyLinkedList object.
// int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
// void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
// void addAtTail(int val) Append a node of value val as the last element of the linked list.
// void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
// void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
// 
//  
// Example 1:
// 
// Input
// ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
// [[], [1], [3], [1, 2], [1], [1], [1]]
// Output
// [null, null, null, null, 2, null, 3]
// 
// Explanation
// MyLinkedList myLinkedList = new MyLinkedList();
// myLinkedList.addAtHead(1);
// myLinkedList.addAtTail(3);
// myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
// myLinkedList.get(1);              // return 2
// myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
// myLinkedList.get(1);              // return 3
// 
//  
// Constraints:
// 
// 0 <= index, val <= 1000
// Please do not use the built-in LinkedList library.
// At most 2000 calls will be made to get, addAtHead, addAtTail,  addAtIndex and deleteAtIndex.
// 
// 
// @desc-end


// @code-start
class MyLinkedList {

	private static class Node {
		public int val;
		public Node prev = null;
		public Node next = null;
		public Node(int val) {
			this.val = val;
		}
	}

	private int size = 0;
	private Node head = new Node(-1);

    /** Initialize your data structure here. */
    public MyLinkedList() {
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
		if(index < 0 || index >= size)
			return -1;
		int i = 0;
		Node tmp = head.next;
		while(tmp != null) {
			if(i == index) {
				return tmp.val;
			}
			tmp = tmp.next;
			i ++;
		}
		return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
		addAtHead(head, val);
    }

	private void addAtHead(Node tmp, int val) {
		Node n = new Node(val);
		if(tmp.next == null) {
			tmp.next = n;
			n.prev = tmp;
		} else {
			n.next = tmp.next;
			n.prev = tmp;
			tmp.next.prev = n;
			tmp.next = n;
		}
		size ++;
	}
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
		Node tmp = head;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		Node n = new Node(val);
		tmp.next = n;
		n.prev = tmp;
		size ++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
		if(index < 0 || index > size) {
			return;
		}
		if(index == size) {
			addAtTail(val);
			return;
		}
		Node tmp = head.next;
		int i = 0;
		while(tmp != null) {
			if(i == index) {
				break;
			}
			tmp = tmp.next;
			i++;
		}
		Node prev = tmp.prev;
		addAtHead(prev, val);
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
		if(index < 0 || index >= size) {
			return;
		}
		Node tmp = head.next;
		int i = 0;
		while(tmp != null) {
			if(i == index) {
				break;
			}
			tmp = tmp.next;
			i++;
		}
		Node prev = tmp.prev;
		prev.next = tmp.next;
		if(tmp.next != null) {
			tmp.next.prev = prev;
		}
		size --;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @code-end
