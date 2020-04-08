import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
 
/**
 * This example demonstrates opening a workbook and reading its elements
 */
public class ReadExcelWorkbook {
    public static void main(String[] args) throws IOException {
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;
        HSSFWorkbook wb = null;
        try
        {
            fileIn = new FileInputStream("E:\\Attachment\\40306724_1583582595141.xls");
            POIFSFileSystem fs = new POIFSFileSystem(fileIn);
            wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            System.out.println(sheet.getLastRowNum());
            for(int i = 0 ; i< sheet.getLastRowNum() ; i++) {
            	HSSFRow rowi = sheet.getRow(i);
                System.out.println(rowi.getCell(0) + " : " + rowi.getCell(1)+ " : " + rowi.getCell(2)+ " : " + rowi.getCell(3)+ " : " + rowi.getCell(4)+ " : " + rowi.getCell(5)+ " : " + rowi.getCell(6));

            }           
           /*
            HSSFRow row0 = sheet.getRow(0);
            HSSFRow row1 = sheet.getRow(1);
            if(row1 != null && row1 != null){
                System.out.println(row0.getCell(0) + " : " + row1.getCell(0));
                System.out.println(row0.getCell(1) + " : " + row1.getCell(1));
                System.out.println(row0.getCell(2) + " : " + row1.getCell(2));
            }
            else{
                System.out.println("Either of rows 0 or 1 is empty");
            }*/
        } finally {
            if(wb != null)
                wb.close();
            if (fileOut != null)
                fileOut.close();
            if (fileIn != null)
                fileIn.close();
        }
    }
}