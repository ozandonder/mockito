import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CaptorTest {

    @Mock
    User user = new User();

    @Captor
    ArgumentCaptor<String> usernameCaptor, passwordCaptor;

    @Test
    void test_captor() {
        user.setUser("jhon", "123qwe");
        verify(user).setUser(usernameCaptor.capture(), passwordCaptor.capture());
        assertAll("User info incorrect",
                () -> assertEquals("jhon", usernameCaptor.getValue()),
                () -> assertEquals("123qwe", passwordCaptor.getValue())
        );
    }
}