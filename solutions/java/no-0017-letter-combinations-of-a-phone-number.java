// @desc-start
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
// 
//  
// Example 1:
// 
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
// Example 2:
// 
// Input: digits = ""
// Output: []
// 
// Example 3:
// 
// Input: digits = "2"
// Output: ["a","b","c"]
// 
//  
// Constraints:
// 
// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].
// 
// @desc-end


// @code-start
class Solution {

	private List<String> ret = new ArrayList<>();
	
    public List<String> letterCombinations(String digits) {
		if(digits.length() == 0)
			return new ArrayList<>();
		List<String> mappings = new ArrayList<>();
		mappings.add("abc");
		mappings.add("def");
		mappings.add("ghi");
		mappings.add("jkl");
		mappings.add("mno");
		mappings.add("pqrs");
		mappings.add("tuv");
		mappings.add("wxyz");
		traverse(mappings, digits, 0, "");
		return ret;
    }

	public void traverse(List<String> mappings, String digits, int index, String comb) {
		if(index == digits.length()) {
			ret.add(comb);
			return;
		}
		int num = digits.charAt(index) - '0';
		String s = mappings.get(num - 2);
		for(int i = 0; i < s.length(); i ++) {
			comb += s.charAt(i);
			traverse(mappings, digits, index + 1, comb);
			comb = comb.substring(0, comb.length() - 1);
		}
	}
}
// @code-end
