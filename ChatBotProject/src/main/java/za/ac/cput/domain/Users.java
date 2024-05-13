package za.ac.cput.domain;

public class Users {
    private String username;
    private String password;
    private String studentNumber;
    private String email;

    public Users(String username, String password, String studentNumber, String email) {
        this.username = username;
        this.password = password;
        this.studentNumber = studentNumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", studentID=" + studentNumber + ", email=" + email + '}';
    }
}
