package ro.neo.userhandler.entities;


import ro.neo.userhandler.entities.enums.State;
import ro.neo.userhandler.entities.enums.UserProfileType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users", schema = "users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "state", nullable = false)
    private final String state = State.ACTIVE.getState();

    @Column(name = "creation_date", nullable = false)
    private Date creationDate = new Date();

    @Column(name = "type", nullable = false)
    private final String type = UserProfileType.USER.getUserProfileType();

    @Column(name = "is_account_non_expired", nullable = false)
    private boolean isAccountNonExpired = true;

    @Column(name = "is_credentials_non_expired", nullable = false)
    private boolean isCredentialsNonExpired = true;

    //TODO: enabled only after email confirmed
    @Column(name = "is_enabled", nullable = false)
    private boolean isEnabled = true;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return this.state;
    }


    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getType() {
        return this.type;
    }

    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }


    public boolean isEnabled() {
        return this.isEnabled;
    }

}
