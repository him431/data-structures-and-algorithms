
public class Kmp {
	static int lps[];
	public static void main(String args[]) {
		String text = "acfacabacabacacdk";
		String pattern = "abaca";
		makeLps(pattern);
		System.out.println(search(pattern,text));
	}
	
	private static boolean search(String pattern, String text) {
		int m = text.length();
		int i=0,j=0;
		while(j<m) {
			if(pattern.charAt(i) == text.charAt(j)) { //match
				i++;
				j++;
				if(i == pattern.length()) {
					return true;
				}
			}
			else { //mismatch
				if(i==0){//if its first char of pattern, so try this with next char of text
					j++;
				}
				else{
					i = lps[i-1];
				}
			}
		}
		return false;
	}
	
	private static void makeLps(String pattern) {
		int n = pattern.length();
		lps = new int[n];
		int i=1 , len = 0;
		
		while(i<n) {
			if(pattern.charAt(i) == pattern.charAt(len)) { //chars are same
				len++;
				lps[i] = len;
				i++;
			}
			else if (len>0) { // char mismatch after some match
				len = lps[len-1];
			}
			else {
				i++;
			}
		}
	}
}
