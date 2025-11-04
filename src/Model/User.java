package Model;

public class User {
    private int id_user;
    private String email;
    private String password;
    private String role;

    public User() {}

    public User(int id_user, String email, String password, String role) {
        this.id_user = id_user;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId_user() { return id_user; }
    public void setId_user(int id_user) { this.id_user = id_user; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public void tampilkanInfo() {
        System.out.println("User: " + email + " | Role: " + role);
    }
    
    public boolean validate() {
        return email != null && !email.isEmpty()
            && password != null && !password.isEmpty()
            && role != null && (role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("user"));
    }

}
