package pl.mrcwojcik.snakeapp.modules.user.registration;

import pl.mrcwojcik.snakeapp.exceptions.UserAlreadyExistsException;
import pl.mrcwojcik.snakeapp.modules.user.User;
import pl.mrcwojcik.snakeapp.modules.user.UserDto;

public interface RegistrationService {

    User register(UserDto userDto) throws UserAlreadyExistsException;
    boolean checkIfUserExists(String email);
    void encodePassword(User user, UserDto userDto);


}
