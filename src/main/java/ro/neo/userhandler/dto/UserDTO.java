package ro.neo.userhandler.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "Spring security user object")
public class UserDTO {


    @ApiModelProperty(hidden = true)
    private Long id;

    @NotNull
    @Size(min = 2, max = 255)
    @Email(message = "You should have a valid email formatted string")
    @ApiModelProperty(required = true)
    private String email;

    @NotNull
    @Size(min = 2, max = 255)
    @ApiModelProperty(required = true)
    private String nickname;

    @NotNull
    @Size(min = 2, max = 255)
    @ApiModelProperty(required = true)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 255)
    @ApiModelProperty(required = true)
    private String lastName;

    @NotNull
    @Size(min = 2, max = 255)
    @ApiModelProperty(required = true)
    private String password;

    private Date creationDate = new Date();

    @ApiModelProperty(hidden = true)
    private String type;

    @ApiModelProperty(hidden = true)
    private String state;

    @ApiModelProperty(hidden = true)
    private boolean isAccountNonExpired;

    @ApiModelProperty(hidden = true)
    private boolean isAccountNonLocked;

    @ApiModelProperty(hidden = true)
    private boolean isCredentialsNonExpired;

    @ApiModelProperty(hidden = true)
    private boolean isEnabled;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
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

    public void setType(final String type) {
        this.type = type;
    }

    public String getState() {
        return this.state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    public void setAccountNonExpired(final boolean accountNonExpired) {
        this.isAccountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    public void setAccountNonLocked(final boolean accountNonLocked) {
        this.isAccountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(final boolean credentialsNonExpired) {
        this.isCredentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(final boolean enabled) {
        this.isEnabled = enabled;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
