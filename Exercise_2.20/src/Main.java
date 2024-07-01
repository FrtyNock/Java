import java.lang.Math;
import java.util.HashMap;
import  java.util.Map;

public class Main {
    public static void main(String[] args) {

        int[] a = new int[20];
        for(int i = 0; i < 20; i++){
            a[i] = (int) Math.round((Math.random() * 14) + 1);
        }

        System.out.print("[");
        for(int i = 0; i < 15; i++){
            System.out.print(a[i]);
            if (i != 14)
                System.out.print(", ");
        }
        System.out.print("]");
        System.out.println();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < 15; i++){
            int n = 0;
            for(int j = 0; j < 15; j++){
                if (a[j] == a[i])
                    n++;
            }
            map.put(a[i], n);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > 1)
                System.out.println("Число '" + entry.getKey() + "' встречается " + entry.getValue() + " раза");
        }

    }
}