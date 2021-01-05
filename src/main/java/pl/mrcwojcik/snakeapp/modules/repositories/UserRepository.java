package pl.mrcwojcik.snakeapp.modules.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mrcwojcik.snakeapp.modules.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
