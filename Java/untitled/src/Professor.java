public class Professor extends Person {
    public void addLecture(String lectureName, String lectureCode) {
        Lecture lecture = new Lecture();

        lecture.setLectureCode(lectureCode);
        lecture.setLectureName(lectureName);
    }
}