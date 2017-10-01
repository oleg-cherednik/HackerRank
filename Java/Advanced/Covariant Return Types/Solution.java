/**
 * @author Oleg Cherednik
 * @since 01.10.2017
 */
public class Solution {
}

class Flower {
    public String whatsYourName() {
        return "I have many names and types.";
    }
}

class Jasmine extends Flower {
    public String whatsYourName() {
        return "Jasmine";
    }
}

class Lily extends Flower {
    public String whatsYourName() {
        return "Lily";
    }
}

class Lotus extends Flower {
    public String whatsYourName() {
        return "Lotus";
    }
}

abstract class State {
    public abstract Flower yourNationalFlower();
}

class WestBengal extends State {
    public Jasmine yourNationalFlower() {
        return new Jasmine();
    }
}

class Karnataka extends State {
    public Lotus yourNationalFlower() {
        return new Lotus();
    }
}

class AndhraPradesh extends State {
    public Lily yourNationalFlower() {
        return new Lily();
    }
}
