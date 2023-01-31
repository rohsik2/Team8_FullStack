package site.devroad.softeer.src.user.dto;

public class PostSignUpReq {
    private String email;
    private String name;
    private String phoneNumber;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean hasNull() {
        if (email == null || name == null || phoneNumber == null || password == null)
            return true;
        if (email.equals("") || name.equals("") || phoneNumber.equals("") || password.equals(""))
            return true;
        return false;
    }
}
