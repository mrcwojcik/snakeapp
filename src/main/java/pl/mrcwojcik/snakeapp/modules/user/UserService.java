package pl.mrcwojcik.snakeapp.modules.user;

public interface UserService {

    User findUserByEmail(String email);
    User findUserById(long id);

}
