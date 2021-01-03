class Person {
    String name;
    String id;

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person {
    String grade;
    String deparment;

    public Student(String name) {
        super(name);
    }
}

public class DowncastingEx {
    public static void main(String[] args) {
        Person p = new Student("이재문");
        Student s;

        s = (Student)p;

        System.out.println(s.name);
        s.grade = "A";
    }
}


