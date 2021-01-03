import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String StudentName;
        int StudentAge;
        int StudentGrade;

        System.out.print("Name  >> ");
        StudentName = scanner.nextLine();
        System.out.print("Age   >> ");
        StudentAge = Integer.parseInt(scanner.nextLine());
        System.out.print("Grade >> ");
        StudentGrade = Integer.parseInt(scanner.nextLine());
    }
}
