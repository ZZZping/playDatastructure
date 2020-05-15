import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        String s = "abc";
        System.out.println(s.hashCode());

        Student student = new Student(3,2,"TaoTao", "Song");
        System.out.println(student);
        System.out.println(student.hashCode());

        HashSet<Student> set = new HashSet<>();
        set.add(student);

        HashMap<Student, Integer> scores = new HashMap<>();
        scores.put(student, 100);

        Student student1 = new Student(3, 2, "TAOTAO", "Song");
        System.out.println(student1);
    }
}
