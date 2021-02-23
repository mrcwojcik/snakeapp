package pl.mrcwojcik.snakeapp.modules.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import pl.mrcwojcik.snakeapp.modules.account.Account;
import pl.mrcwojcik.snakeapp.modules.account.AccountDto;
import pl.mrcwojcik.snakeapp.modules.account.AccountService;
import pl.mrcwojcik.snakeapp.modules.utils.TokenDecoder;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;
    private final TokenDecoder tokenDecoder;
    private final Logger logger = LogManager.getLogger(AccountController.class);

    public AccountController(AccountService accountService, TokenDecoder tokenDecoder) {
        this.accountService = accountService;
        this.tokenDecoder = tokenDecoder;
    }

    @PostMapping("/account/add")
    public Account addAccount(@RequestBody AccountDto accountDto, @RequestHeader("Authorization") String token){
        Account account = accountService.addAccount(accountDto, tokenDecoder.decodeToken(token));
        logger.info(account);
        return account;
    }

    @GetMapping("/accounts")
    public List<AccountDto> showAccounts(@RequestHeader("Authorization") String token){
        return accountService.showAccounts(tokenDecoder.decodeToken(token));
    }

    @GetMapping("/account/{accountId}")
    public AccountDto singleAccount(@PathVariable long accountId){
        return accountService.getAccount(accountId);
    }

    @GetMapping("/account/{id}/edit")
    public AccountDto editAccountGet(@PathVariable long accountId){
        return accountService.getAccount(accountId);
    }

    @PutMapping("/account/{id}/edit")
    public Account editAccountPut(@RequestBody AccountDto accountDto){
        return accountService.updateAccount(accountDto);
    }

    @DeleteMapping("/account/{id}/delete")
    public void deleteAccount(@PathVariable long accountId){
        accountService.deleteAccount(accountId);
    }

}
