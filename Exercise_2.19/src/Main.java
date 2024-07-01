import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        int a, b, c;
        System.out.println("Введите 3 числа");
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();

        boolean p = false;
        if (a % 5 == 0){
            System.out.print("a=" + a);
            p = true;
        }
        if (b % 5 == 0){
            if (p == true)
                System.out.print(", ");
            System.out.print("b=" + b);
            p = true;
        }
        if (c % 5 == 0){
            if (p == true)
                System.out.print(", ");
            System.out.print("c=" + c);
            p = true;
        }
        if (p == false)
            System.out.print("нет значений, кратных 5");

        System.out.println();

        System.out.println("Резутьтат целочисленного деления a на b: " + (a / b));

        double d = (double) a / b;
        System.out.printf("Результат деления a на b: %.12f%n", d);
        System.out.printf("Результат деления a на b с округлением в большую сторону: %.0f%n", Math.ceil(d));
        System.out.printf("Результат деления a на b с округлением в меньшую сторону: %.0f%n", Math.floor(d));
        System.out.println("Результат деления a на b с математическим округлением: " + Math.round(d));

        System.out.println("Остаток от деления b на c: " + (b % c));

        System.out.println("Наименьшее значение из a и b: " + Math.min(a, b));
        System.out.println("Наибольшее значение из b и c: " + Math.max(b, c));
    }
}