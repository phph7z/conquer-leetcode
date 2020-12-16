// @desc-start
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
// 
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// 
//  
// Example 1:
// 
// Input: s = "()"
// Output: true
// 
// Example 2:
// 
// Input: s = "()[]{}"
// Output: true
// 
// Example 3:
// 
// Input: s = "(]"
// Output: false
// 
// Example 4:
// 
// Input: s = "([)]"
// Output: false
// 
// Example 5:
// 
// Input: s = "{[]}"
// Output: true
// 
//  
// Constraints:
// 
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
// 
// 
// @desc-end


// @code-start
class Solution {
    public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i ++) {
			char b = s.charAt(i);
			if(b == '{' || b == '[' || b == '(') {
				stack.push(b);
			} else if(b == '}') {
				if(stack.isEmpty() || stack.peek() != '{')
					return false;
				stack.pop();
			} else if(b == ']') {
				if(stack.isEmpty() || stack.peek() != '[')
					return false;
				stack.pop();
			} else if(b == ')') {
				if(stack.isEmpty() || stack.peek() != '(')
					return false;
				stack.pop();
			}
		}
		if(!stack.isEmpty())
			return false;
		return true;
    }
}
// @code-end
