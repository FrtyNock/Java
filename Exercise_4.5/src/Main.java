import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        int a = 10000000;
        int b = 1000000000;
        long r = getArithmeticProgressionSum(a, b);

        System.out.println(r);
    }

    public static long getArithmeticProgressionSum (int a, int b) {

        return IntStream.range(a, b).sum();
    }
}