import java.util.Scanner;

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

        String name1, name2;
        Integer age1, age2;

        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя первого пользователя");
        name1 = in.nextLine();
        System.out.println("Введите возраст первого пользователя");
        age1 = in.nextInt();
        in.nextLine();  // Очищаем буфер

        User us1 = new User(name1, age1);

        System.out.println("Введите имя второго пользователя");
        name2 = in.nextLine();
        System.out.println("Введите возраст второго пользователя");
        age2 = in.nextInt();

        User us2 = new User(name2, age2);

        if (us1.getAge() < us2.getAge())
            System.out.println(us1.toString());
        else if (us1.getAge() > us2.getAge())
            System.out.println(us2.toString());
        else
            System.out.println("Возраст пользователей одиноковый");

        in.close();
    }
}