package pl.mrcwojcik.snakeapp.modules.account;

import com.sun.istack.NotNull;
import pl.mrcwojcik.snakeapp.modules.enums.AccountType;
import pl.mrcwojcik.snakeapp.modules.user.User;

import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public class AccountDto {

    private long id;

    @NotEmpty
    private String accountName;

    @NotNull
    @DecimalMin("0")
    private BigDecimal startBalance;

    private BigDecimal actualBalance;
    private AccountType accountType;

    private User user;

}
