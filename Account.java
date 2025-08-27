public class Account {
    public String name;          // accessible everywhere
    protected String email;      // accessible in subclasses or same package
    private String password;     // fully hidden

    // Getter and Setter for email
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return this.password;
    }

    // Setter for password
    public void setPassword(String pass) {
        this.password = pass;
    }
}
