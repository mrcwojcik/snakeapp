package pl.mrcwojcik.snakeapp.modules.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.mrcwojcik.snakeapp.modules.user.UserDto;
import pl.mrcwojcik.snakeapp.modules.user.User;
import pl.mrcwojcik.snakeapp.modules.user.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDto addUser(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

}
