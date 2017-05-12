package ru.sasha.googletests;

public class NewAndConfirmPass {
    private final String pass;
    private final String passAgain;

    public NewAndConfirmPass(String pass, String passAgain) {
        this.pass = pass;
        this.passAgain = passAgain;
    }

    public String getPass() {
        return pass;
    }

    public String getPassAgain() {
        return passAgain;
    }
}
