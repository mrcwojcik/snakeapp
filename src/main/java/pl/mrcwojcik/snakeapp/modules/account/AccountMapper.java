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

    public AccountDto toDto(Account account){
        if (account == null){
            return null;
        }
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setAccountName(account.getAccountName());
        accountDto.setAccountType(account.getAccountType());
        account.setStartBalance(account.getStartBalance());
        accountDto.setActualBalance(account.getActualBalance());
        return accountDto;
    }

}
