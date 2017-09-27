package cop.hackerrank.java.datastructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <h1>Java Priority Queue</h1>
 * In computer science, a priority queue is an abstract data type which is like a regular queue, but where additionally each element has a "priority"
 * associated with it. In a priority queue, an element with high priority is served before an element with low priority. - Wikipedia<br>
 * <br>
 * <hr>
 * <br>
 * In this problem we will test your knowledge on Java Priority Queue.<br>
 * <br>
 * There are a number of students in a school who wait to be served. Two types of events, <tt>ENTER</tt> and <tt>SERVED</tt>, can take place which
 * are
 * described below.
 * <ul>
 * <li><tt>ENTER</tt>: A student with some priority enters the queue to be served.</li>
 * <li><tt>SERVED</tt>: The student with the highest priority is served (removed) from the queue.</li>
 * </ul>
 * A unique id is assigned to each student entering the queue. The queue serves the students based on the following criteria (priority criteria):
 * <ol>
 * <li>The student having the highest <tt>Cumulative Grade Point Average</tt> (CGPA) is served first.</li>
 * <li>Any students having the <tt>same</tt> CGPA will be served by name in ascending case-sensitive alphabetical order.</li>
 * <li>Any students having the <tt>same</tt> CGPA and <tt>name</tt> will be served in ascending order of the id.</li>
 * </ol>
 * Create the following two classes:
 * <ul>
 * <li>The <tt>Student</tt> class should implement:
 * <ul>
 * <li>The constructor <tt>Student(int id, String name, double cgpa)</tt>.</li>
 * <li>The method <tt>int getID()</tt> to return the id of the student.</li>
 * <li>The method <tt>String getName()</tt> to return the name of the student.</li>
 * <li>The method <tt>double getCGPA()</tt> to return the CGPA of the student.</li>
 * </ul>
 * </li>
 * <li>The <tt>Priorities</tt> class should implement the method <tt>List<Student> getStudents(List<String> events)</tt> to process all the given
 * events and return all the students yet to be served.</li>
 * </ul>
 * <h3>Input Format</h3>
 * The first line contains an integer, <tt>n</tt>, describing the total number of events. Each of the  subsequent lines will be of the following two
 * forms:
 * <ul>
 * <li><tt>ENTER name CGPA id</tt>: The student to be inserted into the priority queue.</li>
 * <li><tt>SERVED</tt>: The highest priority student in the queue was served.</li>
 * </ul>
 * The locked stub code in the editor reads the input and tests the correctness of the <tt>Student</tt> and <tt>Priorities</tt> classes
 * implementation.
 * <h3>Constraints</h3>
 * <ul>
 * <li>2 <= n <= 1000</li>
 * <li>0 <= CGPA <= 4.00</li>
 * <li>1 <= id <= 1o<sup>5</sup></li>
 * <li>2 <= |name| <= 30</li>
 * </ul>
 * <h3>Output Format</h3>
 * The locked stub code prints the names of the students yet to be served. If there are no such student, then the code prints <tt>EMPTY</tt>.
 * <h3>Sample Input 0</h3>
 * <pre>
 * 12
 * ENTER John 3.75 50
 * ENTER Mark 3.8 24
 * ENTER Shafaet 3.7 35
 * SERVED
 * SERVED
 * ENTER Samiha 3.85 36
 * SERVED
 * ENTER Ashley 3.9 42
 * ENTER Maria 3.6 46
 * ENTER Anik 3.95 49
 * ENTER Dan 3.95 50
 * SERVED
 * </pre>
 * <h3>Sample Output 0</h3>
 * <pre>
 * Dan
 * Ashley
 * Shafaet
 * Maria
 * </pre>
 * <h3>Explanation 0</h3>
 * In this case, the number of events is 12. Let the name of the queue be <tt>Q</tt>.
 * <ul>
 * <li>John is added to <tt>Q</tt>. So, it contains <tt>(John, 3.75, 50)</tt>.</li>
 * <li>Mark is added to <tt>Q</tt>. So, it contains <tt>(John, 3.75, 50)</tt> and <tt>(Mark, 3.8, 24)</tt>.</li>
 * <li>Shafaet is added to <tt>Q</tt>. So, it contains <tt>(John, 3.75, 50)</tt>, <tt>(Mark, 3.8, 24)</tt>, and <tt>(Shafaet, 3.7, 35)</tt>.</li>
 * <li>Mark is served as he has the highest CGPA. So, <tt>Q</tt> contains <tt>(John, 3.75, 50)</tt> and <tt>(Shafaet, 3.7, 35)</tt>.</li>
 * <li>John is served next as he has the highest CGPA. So, <tt>Q</tt> contains <tt>(Shafaet, 3.7, 35)</tt>.</li>
 * <li>Samiha is added to <tt>Q</tt>. So, it contains <tt>(Shafaet, 3.7, 35)</tt> and <tt>(Samiha, 3.85, 36)</tt>.</li>
 * <li>Samiha is served as she has the highest CGPA. So, <tt>Q</tt> contains <tt>(Shafaet, 3.7, 35)</tt>.</li>
 * <li>Now, four more students are added to <tt>Q</tt>. So, it contains (<tt>(Shafaet, 3.7, 35)</tt>, <tt>(Ashley, 3.9, 42)</tt>, <tt>(Maria, 3.6,
 * 46)</tt>, <tt>(Anik, 3.95, 49)</tt>, and <tt>(Dan, 3.95, 50)</tt>.</li>
 * <li>Anik is served because though both Anik and Dan have the highest CGPA but Anik comes first when sorted in alphabetic order. So, <tt>Q</tt>
 * contains <tt>(Dan, 3.95, 50)</tt>, <tt>(Ashley, 3.9, 42)</tt>, <tt>(Shafaet, 3.7, 35)</tt>, and <tt>(Maria, 3.6, 46)</tt>.
 * </ul>
 * As all events are completed, the name of each of the remaining students is printed on a new line.
 *
 * @author Oleg Cherednik
 * @since 20.09.2017
 */
public class JavaPriorityQueue {
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

    static class Student {
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

    static class Priorities {
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
}


