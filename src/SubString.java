
public class SubString {

	public static void main(String[] args) {
		String s= "RLLLLRRRLR";
		int res = 0;
		for(int i =0 ; i <=s.length() ; i += 2) {
			
			int lastIndex = i+2;
			String subString = s.substring(i, lastIndex);
			
			boolean count = getCount(subString); 			
			while(!count) {
				lastIndex = lastIndex+2;
				count = getCount(s.substring(i,lastIndex));
				
			}
			if(count) {
				i = lastIndex-2;
				res++;
			}
			if(lastIndex == s.length())
				break;
			
		}
		System.out.println(res);
	}

	private static boolean getCount(String subString) {
		int lc = 0,rc =0;
		for(int j =0 ; j< subString.length() ; j++) {
			if(subString.charAt(j) == 'L')
				lc++;
			if(subString.charAt(j) == 'R')
				rc++;
		}
		return (lc==rc) ? true:false;
	}

}
