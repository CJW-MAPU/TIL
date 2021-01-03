import java.util.Scanner;

class Book1 {
    String title, author;

    public Book1(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class BookArray {
    public static void main(String[] args) {
        Book1 [] book = new Book1[2];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < book.length; i++) {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("author: ");
            String author = scanner.nextLine();
            book[i] = new Book1(title, author);
        }

        for (int i = 0; i < book.length; i++) {

        }
    }
}
