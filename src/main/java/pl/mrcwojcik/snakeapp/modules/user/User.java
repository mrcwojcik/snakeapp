package pl.mrcwojcik.snakeapp.modules.user;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotNull
    @ColumnDefault(value = "'ROLE_USER'")
    private String role;

    @Column(name = "enabled", nullable = false, insertable = false)
    @NotNull
    @ColumnDefault(value = "1")
    private boolean enabled;


    public User() {
    }

    public User(String email, @NotEmpty(message = "Password cannot be empty") String password) {
        this.email = email;
        this.password = password;
    }

    public User(long id, @Email(message = "Type e-mail correctly") String email, @NotEmpty(message = "Password cannot be empty") String password) {
        this.id = id;
        this.email = email;
        this.password = password;
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
}
