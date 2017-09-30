/**
 * @author Oleg Cherednik
 * @since 22.09.2017
 */
public class Solution {
    public static void main(String... args) {
        Sports c1 = new Sports();
        Soccre c2 = new Soccre();
        System.out.println(c1.getName());
        c1.getNumberOfTeamMembers();
        System.out.println(c2.getName());
        c2.getNumberOfTeamMembers();
    }
}

class Sports {
    String getName() {
        return "Generic Sports";
    }

    void getNumberOfTeamMembers() {
        System.out.println("Each team has n players in " + getName());
    }
}

class Soccre extends Sports {
    String getName() {
        return "Soccer Class";
    }

    void getNumberOfTeamMembers() {
        System.out.println("Each team has 11 players in " + getName());
    }
}
