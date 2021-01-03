public class Book {
    String title;
    String author;

    public Book(String t) {
        title = t;
        author = "N/A";
    }

    public Book(String t, String a) {
        title = t;
        author = a;
    }

    public static void main(String[] args) {
        Book littlePrince = new Book("Little Prince", "Centak");

        Book loveStory = new Book("ChoonHyangGeon");

        System.out.println(littlePrince.title + " " + littlePrince.author);
        System.out.println(loveStory.title + " " + loveStory.author);
    }
}
