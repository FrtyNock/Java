import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        String date = in.nextLine();
        char[] dst = new char[10];
        date.getChars(6, 10, dst, 0);
        dst[4] = '-';
        date.getChars(3, 5, dst, 5);
        dst[7] = '-';
        date.getChars(0, 2, dst, 8);
        System.out.println(dst);
    }
}