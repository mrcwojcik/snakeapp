package pl.mrcwojcik.snakeapp.modules.user;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public UserDto mapUserToDto(User user){
        return buildUserDto(user);
    }

    private UserDto buildUserDto(User user){
        return new UserDto(user.getEmail(), user.getPassword());
    }

    public User mapDtoToUser(UserDto userDto){
        return buildUser(userDto);
    }

    public User buildUser(UserDto userDto){
        return new User(userDto.getEmail(), userDto.getPassword());
    }

}
