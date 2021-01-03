import java.util.ArrayList;
import java.util.Iterator;

public class Student extends Person {
    private int grade;
    private ArrayList<Lecture> lectureList =new ArrayList<>();

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void addLectureList(Lecture lecture) {
        lectureList.add(lecture);
    }

    public void lectureLookup() {
        Iterator<Lecture> it = lectureList.iterator();

        while(it.hasNext()) {
            System.out.println(it.next().getLectureName() + " " + it.next().getLectureCode());
        }
    }
}
