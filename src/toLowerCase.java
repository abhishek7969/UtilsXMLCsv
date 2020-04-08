
public class toLowerCase {

	public static void main(String[] args) {
		String s = "Hello";
		String res ="";
		for(int i = 0 ; i<s.length();i++) {
			int acicode = (int) s.charAt(i);
			
			if(acicode<=90 && acicode>=65)
				res = res + Character.toString((char) (acicode+32));
			else
				res = res +Character.toString((char)acicode);
		}
		System.out.println(res);

	}

}
