import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String username;
    private String password;

    public void setUser(String userName, String password) {
        this.username = userName;
        this.password = password;
    }
}
