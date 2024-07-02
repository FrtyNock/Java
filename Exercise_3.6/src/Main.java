import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


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

        Scanner in = new Scanner(System.in);

        String name;
        Integer age;

        HashMap<Integer, List<User>> map = new HashMap<Integer, List<User>>();


        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i + 1));
            name = in.nextLine();
            System.out.println("Введите возраст пользователя " + (i + 1));
            age = in.nextInt();
            in.nextLine();  // Очищаем буфер

            User us = new User(name, age);
            map.computeIfAbsent(age, k -> new ArrayList<>()).add(us);
        }

        System.out.println("\nВведите требуемый возраст");
        age = in.nextInt();

        List<User> us_r = map.get(age);


        if (us_r != null) {
            Collections.sort(us_r, Comparator.comparing(User::getName));
            for (User user : us_r) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("Пользователь с возрастом '" + age + "' не найден");
        }

        in.close();
    }
}