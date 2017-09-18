package cop.hackerrank.java.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Java Sort</h1>
 * You are given a list of student information: ID, FirstName, and CGPA. Your task is to rearrange them according to their CGPA in decreasing order.
 * If two student have the same CGPA, then arrange them according to their first name in alphabetical order. If those two students also have the same
 * first name, then order them according to their ID. No two students have the same ID.<br>
 * <br>
 * <b>Hint</b>: You can use comparators to sort a list of objects. See the oracle docs to learn about comparators.
 * <h3>Input Format</h3>
 * The first line of input contains an integer N, representing the total number of students. The next N lines contains a list of student information
 * in the following structure:
 * <pre>
 * ID Name CGPA
 * </pre>
 * <h3>Constraints</h3>
 * <ul>
 * <li>2 <= N <= 1000</li>
 * <li>0 <= ID <= 100000</li>
 * <li>5 <= |Name| <= 30</li>
 * <li>) <= CGPA <= 4.00</li>
 * </ul>
 * The name contains only lowercase English letters. The ID contains only integer numbers without leading zeros. The <tt>CGPA</tt> will contain, at
 * most, 2 digits after the decimal point.
 * <h3>Output Format</h3>
 * After rearranging the students according to the above rules, print the first name of each student on a separate line.
 * <h3>Sample Input</h3>
 * <pre>
 * 5
 * 33 Rumpa 3.68
 * 85 Ashis 3.85
 * 56 Samiha 3.75
 * 19 Samara 3.75
 * 22 Fahim 3.76
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>
 * Ashis
 * Fahim
 * Samara
 * Samiha
 * Rumpa
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 18.09.2017
 */
public class JavaSort {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int res = Double.compare(o2.getCgpa(), o1.getCgpa());
                return res == 0 ? o1.getFname().compareTo(o2.getFname()) : res;
            }
        });

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}
