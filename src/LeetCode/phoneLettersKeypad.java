/*
LETTERPHONE

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.


The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.
*/

public class Solution {
	public ArrayList<String> letterCombinations(String a) {
	    HashMap<Character,String> phoneMap = new HashMap<Character,String>();
	    phoneMap.put('0',"0");
	    phoneMap.put('1',"1");
	    phoneMap.put('2',"abc");
	    phoneMap.put('3',"def");
	    phoneMap.put('4',"ghi");
	    phoneMap.put('5',"jkl");
	    phoneMap.put('6',"mno");
	    phoneMap.put('7',"pqrs");
	    phoneMap.put('8',"tuv");
	    phoneMap.put('9',"wxyz");
	    ArrayList<String> res = new ArrayList<String>();
	    
	    recurse(a, 0, "", phoneMap, res);
	    Collections.sort(res);
	    return res;
	}
	
	public static void recurse(String s, int i, String temp, HashMap<Character,String> phoneMap, ArrayList<String> res){
	    if (i == s.length()){
	        res.add(temp);
	        return;
	    }
	    
	    if (i < s.length()){
	        String str = phoneMap.get(s.charAt(i));
	        for (int k=0; k<str.length(); k++){
	            String tempCopy = temp;
	            tempCopy += str.charAt(k);
	            recurse (s, i+1, tempCopy,phoneMap,res);
	        }
	    }
	}
	
}