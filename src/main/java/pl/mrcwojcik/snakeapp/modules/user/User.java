package pl.mrcwojcik.snakeapp.modules.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.ColumnDefault;
import pl.mrcwojcik.snakeapp.modules.account.Account;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

    @Column(name = "role", nullable = false, insertable = false)
    @ColumnDefault(value = "'ROLE_USER'")
    private String role;

    @Column(name = "enabled", nullable = false, insertable = false)
    @ColumnDefault(value = "1")
    private boolean enabled;

    @OneToMany (mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnoreProperties(value = "user", allowSetters = true)
    private Set<Account> accounts = new HashSet<>();

    public User() {
    }

    public User(String email, @NotEmpty(message = "Password cannot be empty") String password) {
        this.email = email;
        this.password = password;
    }

    public User(long id, String email, @NotEmpty(message = "Password cannot be empty") String password, @NotNull String role, @NotNull boolean enabled, Set<Account> accounts) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        accounts.add(account);
        account.setUser(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
