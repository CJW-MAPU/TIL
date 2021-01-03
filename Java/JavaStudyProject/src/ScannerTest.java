import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



    }
}

class Animal {
    String name;
    int age;

    void eat() { /* ... */ }
    void speak() { /* ... */ }
    void love() { /* ... */ }
}

class Human extends Animal {
    String hobby;
    String job;

    void work() { /* ... */ }
    void cry() { /* ... */ }
    void laugh() { /* ... */ }
}