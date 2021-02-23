package pl.mrcwojcik.snakeapp.modules.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mrcwojcik.snakeapp.modules.account.Account;
import pl.mrcwojcik.snakeapp.modules.user.User;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByUser(User user);

}
