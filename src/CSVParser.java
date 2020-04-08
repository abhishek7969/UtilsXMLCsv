import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CSVParser {

	public static void main(String[] args) throws FileNotFoundException {
		processInputFile("E:\\\\Attachment\\\\15569-27022020\\\\15569-27022020 .XLS");
	}
	
	private static List<String> processInputFile(String inputFilePath) throws FileNotFoundException {
	    List<String> inputList = new ArrayList<String>();
	    try{
	      File inputF = new File(inputFilePath);
	      InputStream inputFS = new FileInputStream(inputF);
	      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
	      inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
	      br.close();
	    } catch (IOException e) {
	    }
	    return inputList ;
	}
	
	private static Function<String, String> mapToItem = (line) -> {
		System.out.print("temp....");
		String[] p = line.split(",");// a CSV has comma separated lines
		String item = new String();
		for (String string : p) {
			String[] rowdata = string.split("\t");
			for(String val : rowdata) {
				System.out.println(val);
			}
		}
		return item;
	};
	
}
