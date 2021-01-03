public class Person implements Action {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void goSchool() {
        System.out.println("Going to School");
    }

    @Override
    public void goHome() {
        System.out.println("Going to Home");
    }
}
