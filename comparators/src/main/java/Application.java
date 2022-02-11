import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("Marcelo", 1);
        students[1] = new Student("Yusei", 2);
        students[2] = new Student("Oiii", 1);
        students[3] = new Student("Marilyn", 0);
        students[4] = new Student("Slipknot", 4);

        System.out.println("By Name\n\n");
        Arrays.sort(students, Student.BY_NAME);

        for(Student student : students) {
            System.out.println(student);
        }

        System.out.println("By Section\n\n");
        Arrays.sort(students, Student.BY_SECTION);

        for(Student student : students) {
            System.out.println(student);
        }

    }
}
