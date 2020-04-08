import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class SingleNumber {

	public static void main(String[] args) {

			int a[]= {2,2,-1,-1,-3};
			
			
			Integer[] boxedArray = Arrays.stream(a).boxed().toArray(Integer[]::new);			
	        CopyOnWriteArrayList<Integer>list = new CopyOnWriteArrayList<>(boxedArray); 
	        
			for(Integer i : list) {
				if(list.remove(new Integer(i))) {
				   if(list.contains(new Integer(i))) {
						list.add(new Integer(i));

				   }
				   if(a.length != list.size())
					   System.out.println(i);
				}
				
			}
		
	}
	
	public int singleNumber(int[] a) {
        return Arrays.stream(a).reduce(0, (ass, x) -> ass ^ x);
	}

}
