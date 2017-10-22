import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Oleg Cherednik
 * @since 22.10.2017
 */
public class Solution {

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        Pattern pattern = Pattern.compile("^\\d+\\s(C|CPP|JAVA|PYTHON|PERL|PHP|RUBY|CSHARP|HASKELL|CLOJURE|BASH|SCALA|ERLANG|CLISP|LUA|"
                + "BRAINFUCK|JAVASCRIPT|GO|D|OCAML|R|PASCAL|SBCL|DART|GROOVY|OBJECTIVEC)$");
        scan.nextLine();

        for (int i = 0; i < N; i++)
            System.out.println(pattern.matcher(scan.nextLine()).find() ? "VALID" : "INVALID");

        scan.close();
    }
}
