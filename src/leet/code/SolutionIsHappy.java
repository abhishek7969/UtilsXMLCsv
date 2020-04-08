package leet.code;

public class SolutionIsHappy {

	public static void main(String[] args) {
		
	}
	
	private static boolean isHappy(int num) {
		if(num < 1) return  false;
		
		while(true) {
			num = getSqaureSum(num);
			 if(num==1 || num==7) return true;
	           if(num<10)  return false;
		}
		

	}


	private static int getSqaureSum(int num) {
		int res = 0;
		while (num != 0) {
			int digit = num % 10;
			res = res + digit * digit;
			num = num / 10;
		}
		return res;
	}

		
		

}
