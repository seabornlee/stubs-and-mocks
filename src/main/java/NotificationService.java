import java.util.List;

public class NotificationService {
    private UserService userService;
    private SmSService smSService;

    public NotificationService(UserService userService, SmSService smSService) {
        this.userService = userService;
        this.smSService = smSService;
    }

    public void notifyUsers() {
        List<User> users = userService.getIphoneUsers();
        for (User user : users) {
            if (user.acceptNotification()) {
                smSService.send(user.getPhoneNumber(), "content");
            }
        }
    }
}
