import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 20.09.2017
 */
public class Solution {
    private static final Scanner scan = new Scanner(System.in);
    private static final Priorities priorities = new Priorities();

    public static void main(String... args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty())
            System.out.println("EMPTY");
        else
            for (Student st : students)
                System.out.println(st.getName());
    }
}

class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getID() {
        return id;
    }

    String getName() {
        return name;
    }

    double getCGPA() {
        return cgpa;
    }

}

class Priorities {
    private static final Comparator<Student> COMPARATOR = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            int res = Double.compare(s2.getCGPA(), s1.getCGPA());
            res = res == 0 ? s1.getName().compareTo(s2.getName()) : res;
            return res == 0 ? Integer.compare(s1.getID(), s2.getID()) : res;
        }
    };

    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>(events.size(), COMPARATOR);

        for (String event : events) {
            String[] parts = event.split(" ");

            if ("ENTER".equals(parts[0]))
                queue.add(new Student(Integer.parseInt(parts[3]), parts[1], Double.parseDouble(parts[2])));
            else if ("SERVED".equals(parts[0]))
                if (!queue.isEmpty())
                    queue.remove();
        }

        List<Student> students = new ArrayList<>(queue.size());

        while (!queue.isEmpty())
            students.add(queue.remove());

        return students;
    }

}
