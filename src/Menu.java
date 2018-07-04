import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {


    private Student student;
    private Warning warning;
    private Exams exams = new Exams();
    private Attendance attendance;
    private Scanner sc1 = new Scanner(System.in);
    private Scanner sc2 = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String className;
    private String exit;
    private List<String> warningMessage = new ArrayList<String>();
    private String anotherGrade;
    private int yearOfClass;
    private int age;
    private int switchNumber;
    private double examGrade;
    private double testGrade;
    private double answerGrade;
    private boolean flag;
    private boolean attendanceFlag;
    private boolean ageFlag;


    public void mainMenu() {
        setStudent();
        while (!flag) {
            firstMenu();
            switch (switchNumber) {
                case 1:
                    setAttendance();
                    break;
                case 2:
                    while (!flag){
                    examsMenu();
                        switch (switchNumber) {
                            case 1:
                            examGrade();
                            break;
                        case 2:
                            testGrade();
                            break;
                        case 3:
                            answerGrade();
                            break;
                        }
                    }
                    break;
                case 3:
                    setWarningMessage();
                    break;
            }
           exitMenu();
        }
        printInfo();
    }

    private void setStudent(){
        System.out.println("Student info: ");
        System.out.println("First Name");
        firstName = sc1.nextLine();
        System.out.println("Last Name");
        lastName = sc1.nextLine();
        System.out.println("Age");
        classYear();
        System.out.println("Class");
        className = sc1.next();
        student = new Student(firstName, lastName, age,+ yearOfClass + className);
    }
    private void setWarningMessage(){

        System.out.println("Please type warning message: ");
        warningMessage.add(sc2.nextLine());
        warning = new Warning(warningMessage);
    }

    private void setAttendance(){
        System.out.println("Is student attended? yes/no");
        exit = sc1.next();
        if (exit.equals("yes")) {
            attendanceFlag = true;
            attendance = new Attendance(attendanceFlag);
        } else {
            attendanceFlag = false;
            attendance = new Attendance(attendanceFlag);
        }
    }

    private void examsMenu(){
        System.out.println("1. Exam");
        System.out.println("2. Test");
        System.out.println("3. Answer");
        switchNumber = sc1.nextInt();
    }

    private void firstMenu(){
        System.out.println("Please choose number: ");
        System.out.println("1. Attendance");
        System.out.println("2. Grade");
        System.out.println("3. Warning");
        switchNumber = sc1.nextInt();
    }

    private void examGrade() {
        System.out.println("Please add exam grade: ");
            examGrade = sc1.nextDouble();
            exams.addExamGrade(examGrade);
            System.out.println("Do you want add another grade: yes/no");
            anotherGrade = sc1.next();
            if (anotherGrade.equals("yes")) {
                flag = false;
            } else {
                flag = true;
            }
    }


    private void testGrade(){
        System.out.println("Please add test grade: ");
        testGrade = sc1.nextDouble();
        exams.addTestGrade(testGrade);
        System.out.println("Do you want add another grade: yes/no");
        anotherGrade = sc1.next();
        if (anotherGrade.equals("yes")) {
            flag = false;
        } else {
            flag = true;
        }
    }

    private void answerGrade(){
        System.out.println("Please add answer grade: ");
        answerGrade = sc1.nextDouble();
        exams.addAnswerGrade(answerGrade);
        System.out.println("Do you want add another grade: yes/no");
        anotherGrade = sc1.next();
        if (anotherGrade.equals("yes")) {
            flag = false;
        } else {
            flag = true;
        }
    }

    private void exitMenu(){
        System.out.println("Do you want exit: yes/no");
        exit = sc1.next();
        if (exit.equals("yes")) {
            flag = true;
        } else
            flag = false;
    }

    private void classYear() {
        while (!ageFlag) {
            age = sc1.nextInt();
            if (age == 6) {
                yearOfClass = 1;
                ageFlag = true;
            } else if (age == 7) {
                yearOfClass = 2;
                ageFlag = true;
            } else if (age == 8) {
                yearOfClass = 3;
                ageFlag = true;
            } else if (age == 9) {
                yearOfClass = 4;
                ageFlag = true;
            } else if (age == 10) {
                yearOfClass = 5;
                ageFlag = true;
            } else if (age == 11) {
                yearOfClass = 6;
                ageFlag = true;
            } else if (age == 12) {
                yearOfClass = 7;
                ageFlag = true;
            } else if (age == 13) {
                yearOfClass = 8;
                ageFlag = true;
            } else {
                ageFlag = false;
                System.out.println("You typed wrong age, choose between 6 - 13 years");
            }
        }
    }
    private void printInfo(){
        System.out.println("Exam grade: "+ examGrade + " test grade: " + testGrade + " answer grade: " + answerGrade);
        System.out.println(student);
        if (attendanceFlag){
            System.out.println("Student: " + student.getFirstName() +  " " + student.getLastName() + " attended");
        } else {
            System.out.println("Student: " + student.getFirstName() + " " + student.getLastName() + " has no attended");
        }
        if (warningMessage.isEmpty()) {
            System.out.println("Student: " + student.getFirstName() +  " " + student.getLastName() + " has no warnings");
        } else {
            System.out.println("Student: " + student.getFirstName() +  " " + student.getLastName() + " " + warningMessage);
        }
    }
}
