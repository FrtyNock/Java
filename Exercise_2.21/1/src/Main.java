import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String str = in.nextLine();

        System.out.println("Введите подстроку");
        String str2 = in.nextLine();

        int n = 0;
        int i = 0;
        while (true) {
            i = str.indexOf(str2, i);
            if (i != -1) {
                n++;
            }
            else
                break;

            i++;
        }

        System.out.println("Подстрока '" + str2 + "' встречается " + n + " раза");

    }
}