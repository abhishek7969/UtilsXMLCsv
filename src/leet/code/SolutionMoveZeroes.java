package leet.code;

public class SolutionMoveZeroes {

	public static void main(String[] args) {
		int nums[]  = {0,1,1,0};  //0,1,0,3,12
		System.out.println(moveZeroes(nums));
	}
	
	
	 public static int[] moveZeroes(int[] nums) {
		 int  pointer = 0;
	        for(int i = 0 ; i < nums.length-1 ; i++) {
	        	if((nums[i+1] > nums[i]) && (nums[i] == 0)) {
	        		int temp = nums[pointer];
	        		nums[pointer] = nums[i+1];
	        		nums[i+1] = temp;
	        	}	        	
        		pointer ++;
        		
        		if(nums[pointer] == 0 &&  nums[pointer-1] == 0) {
        			pointer --;
        		}

	        }
	        return nums;
	 }

}
