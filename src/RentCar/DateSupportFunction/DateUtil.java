package RentCar.DateSupportFunction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateUtil
{
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); // minus number would decrement the days
        return cal.getTime();
    }
    
    public Date inputDate() {
    	try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the Date follow format dd-MM-yyyy: ");

			String date = scanner.next();

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date2=null;
			try {
			    date2 = dateFormat.parse(date); //Parsing the String
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			//System.out.println(date2);
			return date2;
		}
    }
}
