import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatExample {
    public static void main(String[] args) {
        Date date = Calendar.getInstance().getTime();

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);
        
        // Display date with a short day and month name
        formatter = new SimpleDateFormat("dd-MMM-yyyy");
        today = formatter.format(date);
        System.out.println(today);

        
    }
}