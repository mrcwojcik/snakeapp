package pl.mrcwojcik.snakeapp.modules.account;

import com.sun.istack.NotNull;
import pl.mrcwojcik.snakeapp.modules.user.User;

import javax.persistence.*;
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
    private BigDecimal startBalance;

    @ManyToOne
    private User user;

    public Account() {
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
