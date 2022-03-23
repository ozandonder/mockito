import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserTest {

    @InjectMocks
    User user;

    @Mock
    UserService userService;
    AutoCloseable closeable;

    @BeforeEach
    void initUser(){
        user = new User();
        user.setUser("jhon","123qwe");
    }

    @Test
    void test_create_user()
    {
        userService = mock(UserService.class);
        when(userService.createUser("valid")).thenReturn(user);
        user = new User();
        user = userService.createUser("valid");
        assertAll("User info incorrect",
                () -> assertEquals("jhon", user.getUsername()),
                () -> assertEquals("123qwe", user.getPassword())
        );
    }

    @Test
    void closeable_test () throws Exception {
        closeable = MockitoAnnotations.openMocks(this);
        when(userService.createUser("VALID")).thenReturn(user);
        user = new User();
        user = userService.createUser("VALID");
        assertAll("User info incorrect",
                () -> assertEquals("jhon", user.getUsername()),
                () -> assertEquals("123qwe", user.getPassword())
        );
        closeable.close();
    }
}
