package pl.mrcwojcik.snakeapp.modules.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import pl.mrcwojcik.snakeapp.modules.enums.AccountType;
import pl.mrcwojcik.snakeapp.modules.user.User;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String accountName;

    @NotNull
    @DecimalMin("0")
    private BigDecimal startBalance;

    private BigDecimal actualBalance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne (fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "accounts", allowSetters = true)
    private User user;

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

    public BigDecimal getActualBalance() {
        return actualBalance;
    }

    public void setActualBalance(BigDecimal actualBalance) {
        this.actualBalance = actualBalance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", startBalance=" + startBalance +
                ", actualBalance=" + actualBalance +
                ", accountType=" + accountType +
                '}';
    }
}
