public class UserService {

    public User createUser(String json) {
        User user = new User();
        try {
//            user = given()
//                    .contentType(ContentType.JSON)
//                    .body(json)
//                    .when()
//                    .post(url)
//                    .then();
        } catch (RuntimeException rte) {
            throw new RuntimeException(rte);
        }
        return user;
    }
}
