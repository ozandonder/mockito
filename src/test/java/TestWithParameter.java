import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestWithParameter {

    User user;

    @Test
    void test_with_parameter(@Mock UserService userService) {
        user = new User();
        user.setUser("jhon","123qwe");
        when(userService.createUser("valid")).thenReturn(user);
        user = new User();
        user = userService.createUser("valid");
        assertAll("User info incorrect",
                () -> assertEquals("jhon", user.getUsername()),
                () -> assertEquals("123qwe", user.getPassword())
        );
    }

}
