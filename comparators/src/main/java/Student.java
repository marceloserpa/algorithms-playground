import java.util.Comparator;

public class Student {


    public static final Comparator<Student> BY_NAME = new ByName();
    public static final Comparator<Student> BY_SECTION = new BySection();

    private final String name;
    private final int section;

    public Student(String name, int section) {
        this.name = name;
        this.section = section;
    }

    private static class ByName implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    private static class BySection implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getSection() - o2.getSection();
        }
    }

    public String getName() {
        return name;
    }

    public int getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", section=" + section +
                '}';
    }
}
