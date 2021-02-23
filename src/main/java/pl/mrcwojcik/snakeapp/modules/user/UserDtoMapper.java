package pl.mrcwojcik.snakeapp.modules.user;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public PasswordEncoder passwordEncoder;

    public UserDto mapUserToDto(User user){
        return buildUserDto(user);
    }

    private UserDto buildUserDto(User user){
        return new UserDto(user.getEmail(), user.getPassword());
    }


}
