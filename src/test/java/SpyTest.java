import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SpyTest {

    @Spy
    User spyUser = new User();

    @Test
    void spy_test() {
        spyUser.setUser("jhon", "123qwe");
        assertAll("User info incorrect",
                () -> assertEquals("jhon", spyUser.getUsername()),
                () -> assertEquals("123qwe", spyUser.getPassword())
        );
    }

    @Test
    void spy_test_with_stub() {
        Mockito.doReturn("123qwe").when(spyUser).getPassword();
        assertEquals("123qwe", spyUser.getPassword());
    }
}
