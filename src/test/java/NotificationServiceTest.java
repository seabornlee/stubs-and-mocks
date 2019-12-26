import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceTest {
    @Mock
    private SmSService smSService;

    @Mock
    private UserService userService;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    public void should_notify_users_who_accept_notification() {
        when(userService.getIphoneUsers()).thenReturn(asList(
                new User(true, "17345041219"),
                new User()));

        notificationService.notifyUsers();

        verify(smSService, times(1)).send(eq("17345041219"), anyString());
    }
}