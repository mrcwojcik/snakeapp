package pl.mrcwojcik.snakeapp.modules.account;

public interface AccountService {

    Account addAccount(AccountDto accountDto, long userId);

}
