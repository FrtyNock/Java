import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Введите дату в формате dd.MM.yyyy:");
        String str = in.nextLine();

        Date parsingdate;
        try {
            parsingdate = ft.parse(str);

            // увеличение на 45 дней
            Calendar cal = Calendar.getInstance();
            cal.setTime(parsingdate);
            cal.add(Calendar.DAY_OF_MONTH, 45);

            Date newDate = cal.getTime();
            System.out.println("Дата после увеличения на 45 дней: " + ft.format(newDate));

            // сдив в начало года
            cal.setTime(parsingdate);
            cal.set(Calendar.MONTH, Calendar.JANUARY);
            cal.set(Calendar.DAY_OF_MONTH, 1);

            newDate = cal.getTime();
            System.out.println("Дата после сдвига на начало года: " + ft.format(newDate));

            // увеличение на 10 рабочих дней
            cal.setTime(parsingdate);
            int workingDaysToAdd = 10;
            int addedDays = 0;

            while (addedDays < workingDaysToAdd) {
                cal.add(Calendar.DAY_OF_MONTH, 1);
                int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                    addedDays++;
                }
            }

            newDate = cal.getTime();
            System.out.println("Дата после увеличения на 10 рабочих дней: " + ft.format(newDate));

            // ввод другой даты
            System.out.println("Введите вторую дату в формате dd.MM.yyyy:");
            str = in.nextLine();
            Date parsingdate2;
            try {
                parsingdate2 = ft.parse(str);

                // кол-во рабочих дней между датами
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(parsingdate2);
                cal.setTime(parsingdate);
                int workingDays = 0;

                while (cal2.before(cal)) {
                    int dayOfWeek = cal2.get(Calendar.DAY_OF_WEEK);
                    if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                        workingDays++;
                    }
                    cal2.add(Calendar.DAY_OF_MONTH, 1);
                }

                System.out.println("Количество рабочих дней между введенными датами:" + workingDays);



            } catch (ParseException e) {
                System.out.println("Нераспаршена с помощью " + ft);
            }

        } catch (ParseException e) {
            System.out.println("Нераспаршена с помощью " + ft);
        }
    }
}