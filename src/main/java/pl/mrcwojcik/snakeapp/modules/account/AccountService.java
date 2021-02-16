package pl.mrcwojcik.snakeapp.modules.account;

import java.util.List;

public interface AccountService {

    Account addAccount(AccountDto accountDto, long userId);
    List<AccountDto> showAccounts(long userId);
    AccountDto getAccount(long accountId);
    Account updateAccount(AccountDto accountDto);
    void deleteAccount(long accountId);

}
