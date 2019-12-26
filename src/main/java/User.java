public class User {
    private boolean acceptNotification;
    private String phoneNumber;

    public User() {
    }

    public User(boolean acceptNotification, String phoneNumber) {
        this.acceptNotification = acceptNotification;
        this.phoneNumber = phoneNumber;
    }

    public boolean acceptNotification() {
        return acceptNotification;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
