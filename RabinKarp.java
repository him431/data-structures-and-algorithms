
public class RabinKarp {
	static int prime = 31;
	
	public static void main(String args[]) {
		String txt = "pepejeansisthebestofall";
		String pat = "epe";
		
		boolean contains = search(pat,txt);
		System.out.println(contains);
	}
	
	static int hash(String s) {
		int hash = 0;
		for(int i=0; i<s.length();i++) {
			hash += s.charAt(i) * Math.pow(prime, i);
		}
		return hash;
	}

	private static boolean search(String pattern, String text) {
		int n = text.length();
		int p = pattern.length();
		int patternHash = hash(pattern);
		int textHash = hash(text.substring(0, p));
		if(patternHash==textHash && checkStringSegmentEqual(pattern,text,0)) {
			return true;
		}
		for(int i=1; i<=n-p ;i++) {
			textHash = rehash(textHash , text.charAt(i-1), text.charAt(i+p-1) ,p);
			if(textHash==patternHash && checkStringSegmentEqual(pattern,text,i))
				return true;
		}
		return false;
	}

	private static int rehash(int thash, char toRemove, char toAdd, int p) {
		thash -= toRemove;
		thash /= prime;
		thash += toAdd * Math.pow(prime, p-1);
		return thash;
		
	}

	private static boolean checkStringSegmentEqual(String pat, String txt, int start) {
		for(int i=0; i<pat.length(); i++){
			if(pat.charAt(i) != txt.charAt(i+start)) return false;
		}
		return true;
	}
}
