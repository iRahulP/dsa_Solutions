package gfgRecursion;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isPalindrome(String str,int s, int e) {
		if(s==e) {
			return true;
		}
		if(s > e) {
			return true;
		}
		if(str.charAt(s) != str.charAt(e)) {
			return false;
		}
		return isPalindrome(str,s+1,e-1);
	}
}
