package pl.mrcwojcik.snakeapp.modules.account;

import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account mapAccount(AccountDto accountDto){
        Account account = new Account();
        account.setAccountName(accountDto.getAccountName());
        account.setAccountType(accountDto.getAccountType());
        account.setStartBalance(accountDto.getStartBalance());
        account.setActualBalance(accountDto.getStartBalance());
        return account;
    }

}
