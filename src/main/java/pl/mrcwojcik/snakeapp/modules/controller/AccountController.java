package pl.mrcwojcik.snakeapp.modules.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import pl.mrcwojcik.snakeapp.modules.account.Account;
import pl.mrcwojcik.snakeapp.modules.account.AccountDto;
import pl.mrcwojcik.snakeapp.modules.account.AccountService;
import pl.mrcwojcik.snakeapp.modules.utils.TokenDecoder;

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

}
