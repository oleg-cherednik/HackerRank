import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 27.05.2018
 */
public class Solution {

    static int[] gradingStudents(int[] grades) {
        for (int i = 0; i < grades.length; i++)
            if (grades[i] >= 38 && grades[i] % 5 >= 3)
                grades[i] = grades[i] + 5 - grades[i] % 5;

        return grades;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.print(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                System.out.println();
            }
        }
    }
}
