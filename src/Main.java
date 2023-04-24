import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Main
{
    public static void main(String[] args)
    {
        List<Student> students = Arrays.asList(
                new Student("John", 25),
                new Student("Akon", 15),
                new Student("John", 34),
                new Student("John", 21),
                new Student("John", 23),
                new Student("John", 44),
                new Student("John", 33),
                new Student("John", 43),
                new Student("John", 10),
                new Student("John", 56),
                new Student("John", 32),
                new Student("John", 33),
                new Student("John", 20),
                new Student("Tony", 10)
        );

        // Java 7 и ранее

        /*
        Collections.sort(students, new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                int cmp = o1.getName().compareTo(o2.getName());
                if (cmp != 0) {
                    вернуть смп;
                }
                return Integer.valueOf(o1.getAge()).compareTo(o2.getAge());
            }
        });*/

        // Java 8 и выше


        // Использование лямбда-выражений
        students.sort((o1, o2) -> {
            int cmp = o1.getName().compareTo(o2.getName());
            if (cmp != 0) {
                return cmp;
            }
            return Integer.valueOf(o1.getAge()).compareTo(o2.getAge());
        });

        // Использование метода Comparator.comparing()
//        students.sort(Comparator.comparing(Student::getName)
//                .thenComparing(Student::getAge));

        for (Student student : students) {
            System.out.println(student);
        }
    }
}