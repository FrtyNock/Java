import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

class User {
    private String name;
    private Integer age;

    User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String toString() {
        return name + ", возраст " + age + " лет";
    }
}

public class Main {
    public static void main(String[] args) {

        ArrayList<User> us = new ArrayList<User>();
        String name;
        Integer age;

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i + 1));
            name = in.nextLine();
            System.out.println("Введите возраст пользователя " + (i + 1));
            age = in.nextInt();
            in.nextLine();  // Очищаем буфер
            us.add(new User(name, age));
        }

        Collections.sort(us, Comparator.comparingInt(User::getAge));

        System.out.println();

        for (User user : us) {
            System.out.println(user);
        }


        in.close();
    }
}