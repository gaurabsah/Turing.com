package javaCoding;

/*
 Given a string S, return the reversed string where all characters that are not 
 a letter stay in same place and all letters reverse their position
 
 Input: "ab-cd"
 Output: "dc-ba"
 */
public class ReverseString {

	static String reverseString(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s).reverse();

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "ab-cd";
		String reverseString = reverseString(s);
		System.out.println(reverseString);
	}

}
