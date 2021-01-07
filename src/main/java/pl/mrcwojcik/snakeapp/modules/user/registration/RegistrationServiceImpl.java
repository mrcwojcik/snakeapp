package pl.mrcwojcik.snakeapp.modules.user.registration;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mrcwojcik.snakeapp.exceptions.UserAlreadyExistsException;
import pl.mrcwojcik.snakeapp.modules.repositories.UserRepository;
import pl.mrcwojcik.snakeapp.modules.user.User;
import pl.mrcwojcik.snakeapp.modules.user.UserDto;
import pl.mrcwojcik.snakeapp.modules.user.UserDtoMapper;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    private final UserDtoMapper userDtoMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(UserDtoMapper userDtoMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userDtoMapper = userDtoMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(UserDto userDto) throws UserAlreadyExistsException {
        if (checkIfUserExists(userDto.getEmail())){
            throw new UserAlreadyExistsException("User already exists for this email");
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        encodePassword(user, userDto);
        userRepository.save(user);
        return user;
    }

    public boolean checkIfUserExists(String email){
        return userRepository.findByEmail(email) !=null ? true : false;
    }

    public void encodePassword(User user, UserDto userDto){
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    }

}
