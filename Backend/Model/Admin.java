package Model;

public class Admin extends User {

    private String adminRole;

    public Admin(String name, String email, String adminRole) {
        super(name, email);
        this.adminRole = adminRole;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void showRole() {
        System.out.println("Admin Role: " + adminRole);
    }
}