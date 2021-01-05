package pl.mrcwojcik.snakeapp.modules.user;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import pl.mrcwojcik.snakeapp.modules.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserDtoMapper userDtoMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserDtoMapper userDtoMapper, UserRepository userRepository) {
        this.userDtoMapper = userDtoMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto userDto) throws HibernateException {
        User user = userDtoMapper.buildUser(userDto);
        userRepository.save(user);
        return userDto;
    }
}
