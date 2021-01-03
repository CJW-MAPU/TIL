import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.println("Input name : ");
            String s = scanner.next();
            a.add(s);
        }

        for (int i = 0; i < a.size(); i++) {
            String name = a.get(i);
            System.out.print(name + " ");
        }

        int LongestIndex = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(LongestIndex).length() < a.get(i).length()) {
                LongestIndex = i;
            }
        }
        System.out.println("\nLongest Name : " + a.get(LongestIndex));
        scanner.close();
    }
}