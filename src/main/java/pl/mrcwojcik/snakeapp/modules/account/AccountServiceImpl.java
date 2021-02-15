package pl.mrcwojcik.snakeapp.modules.account;

import org.springframework.stereotype.Service;
import pl.mrcwojcik.snakeapp.modules.repositories.AccountRepository;
import pl.mrcwojcik.snakeapp.modules.user.UserService;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountMapper accountMapper;
    private final UserService userService;
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountMapper accountMapper, UserService userService, AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.userService = userService;
        this.accountRepository = accountRepository;
    }

    @Override
    public Account addAccount(AccountDto accountDto, long userId) {
        Account account = accountMapper.mapAccount(accountDto);
        account.setUser(userService.findUserById(userId));
        return accountRepository.save(account);
    }
}
