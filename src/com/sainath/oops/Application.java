package com.sainath.oops;

// Less cohesive class
// One class carries too much unnecessary duties.
public class Application {

    public void doLogin() {
        // login code
    }

    public boolean validateUser(String username, String password) {
        // validation login
        return true;
    }

    public void composeEmail() {
        // email compose logic
    }

    public void displayInbox() {
        // inbox email display logic
    }
}

// High Cohesive class with well defined duties.
class Login {
    public void doLogin() {
        // login code
    }

    public boolean validateUser(String username, String password) {
        // validation login
        return true;
    }
}

class EmailClient {
    public void composeEmail() {
        // email compose logic
    }

    public void displayInbox() {
        // inbox email display logic
    }
}