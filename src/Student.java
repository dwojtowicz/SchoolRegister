public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private String classNumber;

    public Student(String firstName, String lastName, int age, String classNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.classNumber = classNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getClassNumber() {
        return classNumber;
    }

    @Override
    public String toString() {
        return "Student: " + firstName + " " + lastName + ", age " + age + ", class " + classNumber;
    }
}
