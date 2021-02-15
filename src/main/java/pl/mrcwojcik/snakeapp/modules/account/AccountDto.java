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
    private AccountType accountType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getStartBalance() {
        return startBalance;
    }

    public void setStartBalance(BigDecimal startBalance) {
        this.startBalance = startBalance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

}
