import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите дату в формате 'дд.мм.гггг'");

        SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
        String str = in.nextLine();
        Date parsingDate;
        try {
            parsingDate = ft.parse(str);

            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(formatForDateNow.format(parsingDate));
        } catch (ParseException e) {
            System.out.println("Нераспаршена с помощью " + ft);
        }
    }
}