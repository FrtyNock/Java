import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String str = in.nextLine();

        String str2 = str.replace("кака", "вырезанно цунзурой");
        str2 = str2.replace("бяка", "вырезанно цензурой");

        System.out.println(str2);

    }
}