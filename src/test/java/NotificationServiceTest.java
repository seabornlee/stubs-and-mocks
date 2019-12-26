import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class NotificationServiceTest {

    static class SmsServiceStub implements SmSService {
        String lastPhoneNumber;
        int calledTimes = 0;

        @Override
        public void send(String phoneNumber, String content) {
            calledTimes += 1;
            lastPhoneNumber = phoneNumber;
        }
    }

    @Test
    public void should_notify_users_who_accept_notification() {
        SmsServiceStub smSService = new SmsServiceStub();
        UserService userService = new UserService() {
            @Override
            public List<User> getIphoneUsers() {
                return asList(
                        new User(true, "17345041219"),
                        new User());
            }
        };

        NotificationService notificationService = new NotificationService(userService, smSService);
        notificationService.notifyUsers();

        assertEquals(1, smSService.calledTimes);
        assertEquals("17345041219", smSService.lastPhoneNumber);
    }
}