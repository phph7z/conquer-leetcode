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
		if(s.length() % 2 ==1) return false;

		Stack<Character> stack = new Stack<>();
		for(int i =0; i <s.length();i++) {
			char ch = s.charAt(i);
			if(ch=='{' || ch=='[' || ch=='(') {
				stack.push(ch);
			} else if(ch=='}') {
				if(!stack.isEmpty() && stack.peek()=='{')
					stack.pop();
				else
					return false;
			} else if(ch==']') {
				if(!stack.isEmpty() && stack.peek()=='[')
					stack.pop();
				else
					return false;
			} else if(ch==')') {
				if(!stack.isEmpty() && stack.peek()=='(')
					stack.pop();
				else
					return false;
			}
		}
		return stack.isEmpty();
    }
}
// @code-end
