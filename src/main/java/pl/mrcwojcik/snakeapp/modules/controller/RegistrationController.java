package pl.mrcwojcik.snakeapp.modules.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.mrcwojcik.snakeapp.exceptions.UserAlreadyExistsException;
import pl.mrcwojcik.snakeapp.modules.user.User;
import pl.mrcwojcik.snakeapp.modules.user.UserDto;
import pl.mrcwojcik.snakeapp.modules.user.registration.RegistrationService;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    private final RegistrationService registrationService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(RegistrationService registrationService, PasswordEncoder passwordEncoder) {
        this.registrationService = registrationService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public User addUser(@Valid @RequestBody UserDto userDto) throws UserAlreadyExistsException {
        return registrationService.register(userDto);
    }

}
