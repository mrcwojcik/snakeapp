package pl.mrcwojcik.snakeapp.modules.account;

import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;
import pl.mrcwojcik.snakeapp.modules.repositories.AccountRepository;
import pl.mrcwojcik.snakeapp.modules.user.UserService;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<AccountDto> showAccounts(long userId) {
        return accountRepository.findAllByUser(userService.findUserById(userId))
                .stream()
                .map(acc -> accountMapper.toDto(acc))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto getAccount(long accountId) {
        return accountMapper.toDto(accountRepository.findById(accountId).orElse(null));
    }

    @Override
    public Account updateAccount(AccountDto accountDto) {
        Account account = accountRepository.findById(accountDto.getId()).orElse(null);
        if (account == null){
            return null;
        }
        account.setAccountName(accountDto.getAccountName());
        account.setAccountType(accountDto.getAccountType());
        account.setStartBalance(accountDto.getStartBalance());
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(long accountId) {
        accountRepository.delete(accountRepository.findById(accountId).get());
    }
}
